import java.util.ArrayList;

public class Kunden {

	private String name;
	private String kundenNr;

	ArrayList<Auto> autos = new ArrayList<>();

	public Kunden(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKundenNr() {
		int random = (int) ((Math.random()*10)+1);
		int nr = 1;
		this.kundenNr = "" + name.charAt(0) + random + nr;
		nr++;
	}

	public String getKundenNr() {
		return kundenNr;
	}

	public void addAuto(Auto auto) {

		//		if (!(autos.contains(auto)))
		autos.add(auto);

	}

	public String getAutos() {

		String erg = "";
		for (Auto a : autos) {
			erg += a + "\n";
		}
		return erg;

	}

	public static void kundenDatenAnlegen(Kunden kunde, ArrayList<Kunden> kundenListe) {

		kundenListe.add(kunde);

		for (int i = 0; i < kundenListe.size(); i++) {
			if (kundenListe.get(i).getName().equals(kunde.getName())) {
				kundenListe.get(i).setKundenNr();
			}
		}

		System.out.println("Es wurde ein neuer Kundenstamm angelegt: " + "\nIhre KundenNr lautet: "
				+ kunde.getKundenNr() + "\n Name: " + kunde.getName());

	}

	public String getDetails(Kunden kunde) {

		String erg = "";
		for (Auto a : autos) {

			erg += "Der " + a.getMarke() + " mit der Kennung " + a.getId() + " wurde vermietet an: "
					+ kunde.getKundenNr() + ", " + kunde.getName();
		}

		return erg;

	}

	public void returnCar(Kunden k, int removeStelle) {

		k.autos.remove(removeStelle);

	}

	public void wunschAutowählen(Kunden kunde, int position) {

		for(int i = 0; i < AutoVermietung.carStorage.size(); i++) {

			if(AutoVermietung.getCarStorage().get(i).isVermietet() == false) {
				kunde.addAuto(AutoVermietung.getCarStorage().get(position-1));
				AutoVermietung.getCarStorage().get(position-1).setVermietet(true);

				if(AutoVermietung.getCarStorage().get(i).isVermietet()==true) {
					listeSortieren();
				}
								
				break;

			}

		}

		System.out.println(kunde.getAutos());

	}

	public void listeSortieren() {

		Auto temp = null;

		for(int i = 0; i < AutoVermietung.carStorage.size(); i++) {
			for(int j = i+1; j<AutoVermietung.carStorage.size(); j++) {
				if(AutoVermietung.getCarStorage().get(i).isVermietet()==true) {
					temp = AutoVermietung.carStorage.get(i);
					AutoVermietung.carStorage.set(i, AutoVermietung.carStorage.get(j));
					AutoVermietung.carStorage.set(j, temp);
				}
			}
		}
	}

}
