package tw.com.common;

public class TrainTimeItem {
	private String Serno = null;
	private String Trips = null;
	private String MSerno = null;
	private String Order1 = null;

	public String getSerno() {
		return Serno;
	}

	public void setSerno(String serno) {
		Serno = serno;
	}

	public String getTrips() {
		return Trips;
	}

	public void setTrips(String trips) {
		Trips = trips;
	}

	public String getMSerno() {
		return MSerno;
	}

	public void setMSerno(String mSerno) {
		MSerno = mSerno;
	}

	public String getOrder1() {
		return Order1;
	}

	public void setOrder1(String order1) {
		Order1 = order1;
	}

	public String getRoute2() {
		return route2;
	}

	public void setRoute2(String route2) {
		this.route2 = route2;
	}

	public String getArrtime() {
		return arrtime;
	}

	public void setArrtime(String arrtime) {
		this.arrtime = arrtime;
	}

	public String getDeptime() {
		return deptime;
	}

	public void setDeptime(String deptime) {
		this.deptime = deptime;
	}

	private String route2 = null;
	private String arrtime = null;
	private String deptime = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
