package tw.com.common;

public class TrainItem {
	private String Serno = null;
	private String train = null;
	private String MSerno = null;
	private String Station = null;
	private String arrtime = null;
	private String deptime = null;
	private String seat = null;
	private String carclass = null;

	public String getSerno() {
		return Serno;
	}

	public void setSerno(String serno) {
		Serno = serno;
	}

	public String getTrain() {
		return train;
	}

	public void setTrain(String train) {
		this.train = train;
	}

	public String getMSerno() {
		return MSerno;
	}

	public void setMSerno(String mSerno) {
		MSerno = mSerno;
	}

	public String getStation() {
		return Station;
	}

	public void setStation(String station) {
		Station = station;
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

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getCarclass() {
		return carclass;
	}

	public void setCarclass(String carclass) {
		this.carclass = carclass;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
