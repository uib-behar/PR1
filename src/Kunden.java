import java.util.ArrayList;

public class Kunden {

	private String name;
	private String kundenNr;

	ArrayList<Auto> autos = new ArrayList<>();

	public Kunden(String name) {
		this.name = name;
		setKundenNr();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKundenNr() {
		int random = (int) ((Math.random()*10));
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

	public static void kundenDatenAnlegen(Kunden kunde) {
		
		kunde.setKundenNr();

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
