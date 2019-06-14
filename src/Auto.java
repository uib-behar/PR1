
public class Auto {

	private String id;
	private String marke;
	private int kmStand;
	private boolean vermietet;

	public Auto(String id, String marke, int kmStand) {

		setId(id);
		this.marke = marke;
		this.kmStand = kmStand;
		setVermietet(false);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {

		if (id.length() < 4) {
			throw new RuntimeException("ungültige ID");
		}
		this.id=id;
	}

	public String getMarke() {
		return marke;
	}

	public int getKmStand() {
		return kmStand;
	}

	public void setKmStand(int gefahreneKm) {
		this.kmStand = kmStand + gefahreneKm;
	}

	public boolean isVermietet() {
		return vermietet;
	}

	public void setVermietet(boolean vermietet) {
		this.vermietet = vermietet;
	}

	public String toString() {
		return "\nID: " + getId() + "\nMarke: " + getMarke() + "\nKmStand: " 
				+ getKmStand() + " Km " + "\nvermietet: " + isVermietet();
	}

}
