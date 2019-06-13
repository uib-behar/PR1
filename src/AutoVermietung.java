import java.util.ArrayList;

public class AutoVermietung {


	ArrayList<Auto> carStorage = new ArrayList<>();
	
	ArrayList<Kunden> kundenListe = new ArrayList<>();


	public ArrayList<Auto> getCarStorage() {

		return carStorage;
	}
	
	public ArrayList<Kunden> getKundenListe() {
		return kundenListe;
	}

	public String getDetailsOfStorage() {

		String erg = "";
		int c = 1;

		for (Auto a : carStorage) {

			if(a.isVermietet()==false) {
			erg += "\n" + c + ": " + a.getMarke();
				c++;
			}

		}
		return " Zu vermieten: " + erg;

	}
	
	public Kunden kundenSetzen(Kunden kunde) {

		for(int i = 0; i < kundenListe.size(); i++) {

			if(kundenListe.get(i).getName().equals(kunde.getName())) {

				return kundenListe.get(i);
			}

		}

		return null;
	}
	
	public void kundenDatenAnlegen(Kunden kunde) {

		kundenListe.add(kunde);

		for(int i = 0; i < kundenListe.size(); i++) {
			if(kundenListe.get(i).getName().equals(kunde.getName())) {
				kundenListe.get(i).setKundenNr();
			}
		}

		System.out.println("\nEs wurde ein neuer Kundenstamm angelegt: " + "\nIhre Kundennummer: " + kunde.getKundenNr() + "\n Name: "
				+ kunde.getName());

	}
	
	public void wunschAutowählen(Kunden kunde, int position, AutoVermietung av) {

		for(int i = 0; i < av.carStorage.size(); i++) {

			if(av.getCarStorage().get(i).isVermietet() == false) {
				kunde.addAuto(av.getCarStorage().get(position-1));
				av.getCarStorage().get(position-1).setVermietet(true);

				if(av.getCarStorage().get(i).isVermietet()==true) {
					listeSortieren(av);
				}
								
				break;

			}

		}

		System.out.println(kunde.getAutos());

	}
	
	
	public void listeSortieren(AutoVermietung av) {

		Auto temp = null;

		for(int i = 0; i < av.carStorage.size(); i++) {
			for(int j = i+1; j<av.carStorage.size(); j++) {
				
				if(av.getCarStorage().get(i).isVermietet()==true) {
					
					temp = av.carStorage.get(i);
					av.carStorage.set(i, av.carStorage.get(j));
					av.carStorage.set(j, temp);
				}
			}
		}
	}
	
}
