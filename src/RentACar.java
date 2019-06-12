import java.util.ArrayList;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class RentACar {

	static Scanner sc = new Scanner(System.in);

	static ArrayList <Kunden> kundenListe = new ArrayList<>();


	public static void main(String[] args) {

		String name = "";
		boolean b = true;

		Kunden kunde = null;

		AutoVermietung.getCarStorage().add(new Auto("MA-X-1","BMW 118",10000,false));
		AutoVermietung.getCarStorage().add(new Auto("MA-QF-203", "Skoda Fabia", 23400, false));
		AutoVermietung.getCarStorage().add(new Auto("MA-A-11", "Audi A3", 15750, false));
		AutoVermietung.getCarStorage().add(new Auto("HD-BF-449", "Renault Sandero", 73000, false));
		AutoVermietung.getCarStorage().add(new Auto("HH-A-09", "VW Golf VII", 25400, false));
		AutoVermietung.getCarStorage().add(new Auto("F-FM-60", "Opel Astra", 12500, false)); 
		AutoVermietung.getCarStorage().add(new Auto("HH-BW-68", "Mercedes-Benz A200", 45250, false));

		System.out.println("Wilkommen bei Drive'N Life!");


		do {

			int position = 0;

			System.out.print("Möchten Sie einen neuen Kundenstamm anlegen? (j/n)\t> ");
			String str = sc.nextLine();

			if(str.toLowerCase().equals("j") || str.toLowerCase().equals("ja")) {
				System.out.print("\nBitte geben Sie Ihren Namen ein: \n> ");
				name = sc.nextLine();

				kunde = new Kunden(name);
				kundenDatenAnlegen(kunde);
			}


			do {	

				System.out.print("\nRent Car - 1"
						+ "\nReturn Car - 2 "
						+ "\nShow My Storage - 3 \n > ");
				int zahl = Integer.parseInt(sc.nextLine());

				if (zahl ==1) {
					System.out.print(AutoVermietung.getDetailsOfStorage() + "\n\nIhre Wahl: ");
					position = Integer.parseInt(sc.nextLine());
					kunde.wunschAutowählen(kunde, position);
				}

				else if (zahl == 2) {
					System.out.println(kunde.getAutos());
					System.out.print("Bitte Auto auswählen \t> ");
					position = Integer.parseInt(sc.nextLine())-1;

					System.out.println("Wie viele Km sind Sie gefahren?");
					int drived = Integer.parseInt(sc.nextLine());
					kunde.autos.get(position).setKmStand(kunde.autos.get(position).getKmStand(), drived);
					AutoVermietung.getCarStorage().get(position).setVermietet(false);

					Auto a = kunde.autos.get(position);
					AutoVermietung.carStorage.add(a);

					kunde.returnCar(kunde,position);

				}
				else if(zahl ==3) {

					System.out.println(kunde.getAutos());

				} else {

					b = true;
				}

			} while(!b);

			System.out.print("Ins Hauptmenü zurück > 1"
					+ "\nProgramm beenden > 2 \nIhre Wahl: ");
			int x = Integer.parseInt(sc.nextLine());

			if (x == 1) {
				kundenSetzen(kunde);
				b = true;

			} else if(x == 2) {
				System.out.println("Programm wird beendet!");
				b = false;
			}


		} while (b);
		System.out.println("Gute Fahrt!");

	}


	public static void kundenDatenAnlegen(Kunden kunde) {

		kundenListe.add(kunde);

		for(int i = 0; i < kundenListe.size(); i++) {
			if(kundenListe.get(i).getName().equals(kunde.getName())) {
				kundenListe.get(i).setKundenNr();
			}
		}

		System.out.println("\nEs wurde ein neuer Kundenstamm angelegt: " + "\nIhre Kundennummer: " + kunde.getKundenNr() + "\n Name: "
				+ kunde.getName());

	}

	public static Kunden kundenSetzen(Kunden kunde) {

		for(int i = 0; i < kundenListe.size(); i++) {

			if(kundenListe.get(i).getName().equals(kunde.getName())) {

				return kundenListe.get(i);

			}

		}

		return null;
	}

}
