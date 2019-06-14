import java.util.ArrayList;

public class AutoVermietung {


	ArrayList<Auto> carStorage = new ArrayList<>();
	
	ArrayList<Kunden> kundenListe = new ArrayList<>();
	
	public AutoVermietung() {
		
		carStorage.add(new Auto("MA-X-1","BMW 118",10000));
		carStorage.add(new Auto("MA-QF-203", "Skoda Fabia", 23400));
		carStorage.add(new Auto("MA-A-11", "Audi A3", 15750));
		carStorage.add(new Auto("HD-BF-449", "Renault Sandero", 73000));
		carStorage.add(new Auto("HH-A-09", "VW Golf VII", 25400));
		carStorage.add(new Auto("F-FM-60", "Opel Astra", 12500)); 
		carStorage.add(new Auto("HH-BW-68", "Mercedes-Benz A200", 45250));
	}


	public ArrayList<Auto> getCarStorage() {

		return carStorage;
	}
	
	public ArrayList<Kunden> getKundenListe() {
		return kundenListe;
	}

	public String getDetailsOfStorage() {

		String erg = "";
		int c = 1;

		for (Auto a : getCarStorage()) {

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
	
	public void wunschAutowählen(Kunden kunde, int position) {

		for(int i = 0; i < getCarStorage().size(); i++) {

			if(getCarStorage().get(i).isVermietet() == false) {
				kunde.addAuto(getCarStorage().get(position-1));
				getCarStorage().get(position-1).setVermietet(true);

				if(getCarStorage().get(i).isVermietet()==true) {
					listeSortieren();
				}
								
				break;

			}

		}

		System.out.println(kunde.getAutos());

	}
	
	
	public void listeSortieren() {

		Auto temp = null;

		for(int i = 0; i < getCarStorage().size(); i++) {
			for(int j = i+1; j<getCarStorage().size(); j++) {
				
				if(getCarStorage().get(i).isVermietet()==true) {
					
					temp = getCarStorage().get(i);
					getCarStorage().set(i, getCarStorage().get(j));
					getCarStorage().set(j, temp);
				}
			}
		}
	}
	
}
