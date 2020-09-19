package tw.com.common;

import java.io.Serializable;
import java.util.ArrayList;

public class Station_TrainItem implements Serializable{
	private String Id = null;
	private String StationID = null;
	private String StationName = null;
	private String TrainNo = null;
	private String Direction = null;
	private String TrainTypeID = null;
	private String TrainTypeName = null;
	private String TripLine = null;
	private String Note = null;

	private String StopSequence = null;
	private String StartingStationID = null;
	private String StartingStationName = null;
	private String EndingStationID = null;
	private String EndingStationName = null;
	private String ArrivalTime = null;
	private String DepartureTime = null;
	private ArrayList<Station_TrainItem> Trains = null;

	public ArrayList<Station_TrainItem> getTrains() {
		return Trains;
	}

	public void setTrains(ArrayList<Station_TrainItem> trains) {
		Trains = trains;
	}

	public String getStopSequence() {
		return StopSequence;
	}

	public void setStopSequence(String stopSequence) {
		StopSequence = stopSequence;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getStationID() {
		return StationID;
	}

	public void setStationID(String stationID) {
		StationID = stationID;
	}

	public String getStationName() {
		return StationName;
	}

	public void setStationName(String stationName) {
		StationName = stationName;
	}

	public String getTrainNo() {
		return TrainNo;
	}

	public void setTrainNo(String trainNo) {
		TrainNo = trainNo;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		Direction = direction;
	}

	public String getTrainTypeID() {
		return TrainTypeID;
	}

	public void setTrainTypeID(String trainTypeID) {
		TrainTypeID = trainTypeID;
	}

	public String getTrainTypeName() {
		return TrainTypeName;
	}

	public void setTrainTypeName(String trainTypeName) {
		TrainTypeName = trainTypeName;
	}

	public String getTripLine() {
		return TripLine;
	}

	public void setTripLine(String tripLine) {
		TripLine = tripLine;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getStartingStationID() {
		return StartingStationID;
	}

	public void setStartingStationID(String startingStationID) {
		StartingStationID = startingStationID;
	}

	public String getStartingStationName() {
		return StartingStationName;
	}

	public void setStartingStationName(String startingStationName) {
		StartingStationName = startingStationName;
	}

	public String getEndingStationID() {
		return EndingStationID;
	}

	public void setEndingStationID(String endingStationID) {
		EndingStationID = endingStationID;
	}

	public String getEndingStationName() {
		return EndingStationName;
	}

	public void setEndingStationName(String endingStationName) {
		EndingStationName = endingStationName;
	}

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
