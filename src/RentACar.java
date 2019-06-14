import java.util.Scanner;


public class RentACar {


	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		AutoVermietung av = new AutoVermietung();

		String name = "";
		boolean b = true;

		Kunden kunde = null;
		

		System.out.println("Wilkommen bei Drive'N Life!");

		do {

			int position = 0;

			System.out.print("Möchten Sie einen neuen Kundenstamm anlegen? (j/n)\t> ");
			String str = sc.nextLine();

			if(str.toLowerCase().equals("j") || str.toLowerCase().equals("ja")) {
				System.out.print("\nBitte geben Sie Ihren Namen ein: \n> ");
				name = sc.nextLine();

				kunde = new Kunden(name);
				av.kundenDatenAnlegen(kunde);
			}


			do {	

				System.out.print("\nRent Car - 1"
						+ "\nReturn Car - 2 "
						+ "\nShow My Storage - 3 \n > ");
				int zahl = Integer.parseInt(sc.nextLine());

				if ( zahl == 1) {
			
					System.out.print(av.getDetailsOfStorage() + "\n\nIhre Wahl: ");
					position = Integer.parseInt(sc.nextLine());


					av.wunschAutowählen(kunde, position);

				}
				else if (zahl == 2) {
					System.out.println(kunde.getAutos());
					System.out.print("Bitte Auto auswählen \t> ");
					position = Integer.parseInt(sc.nextLine())-1;

					System.out.println("Wie viele Km sind Sie gefahren?");
					int drived = Integer.parseInt(sc.nextLine());
					kunde.autos.get(position).setKmStand(drived);

					kunde.autos.get(position).setVermietet(false);

					av.carStorage.add(kunde.autos.get(position));

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
				av.kundenSetzen(kunde);
				b = true;

			} else if(x == 2) {
				System.out.println("Programm wird beendet!");
				b = false;
			}


		} while (b);
		System.out.println("Gute Fahrt!");

	}

}
