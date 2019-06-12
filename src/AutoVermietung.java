import java.util.ArrayList;

public class AutoVermietung {

	private static int bestand = 0;

	static ArrayList<Auto> carStorage = new ArrayList<>();


	public static ArrayList<Auto> getCarStorage() {

		return carStorage;
	}

	static String getDetailsOfStorage() {

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
}
