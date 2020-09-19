package com.tutorialspoint;

import java.util.Map;

public class TrainsItem {
	private String Serno = null;
	private String TrainNumber = null;
	private String Mserno = null;
	private String Note = null;
	private String Station = null;
	private String DepartureTime = null;
	private String ArrivalsTime = null;
	private String EndingStationName = null;
	private String StartingStationName = null;
	private String Price1 = null;
	private String Price2 = null;
	private String Price3 = null;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
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

	public String getStopSequence() {
		return StopSequence;
	}

	public void setStopSequence(String stopSequence) {
		StopSequence = stopSequence;
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

	public String getStartingStationID() {
		return StartingStationID;
	}

	public void setStartingStationID(String startingStationID) {
		StartingStationID = startingStationID;
	}

	public String getEndingStationID() {
		return EndingStationID;
	}

	public void setEndingStationID(String endingStationID) {
		EndingStationID = endingStationID;
	}

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	private String Id = null;
	private String Direction = null;
	private String TrainTypeID = null;
	private String TrainTypeName = null;
	private String TripLine = null;
	private String StopSequence = null;
	private String StationID = null;
	private String StationName = null;
	private String StartingStationID = null;
	private String EndingStationID = null;
	private String ArrivalTime = null;
	private Map<String, String> seat = null;

	public void setSeat(Map<String, String> seat) {
		this.seat = seat;
	}

	public String getPrice1() {
		return Price1;
	}

	public void setPrice1(String price1) {
		Price1 = price1;
	}

	public String getPrice2() {
		return Price2;
	}

	public void setPrice2(String price2) {
		Price2 = price2;
	}

	public String getPrice3() {
		return Price3;
	}

	public void setPrice3(String price3) {
		Price3 = price3;
	}

	public String getEndingStationName() {
		return EndingStationName;
	}

	public void setEndingStationName(String endingStationName) {
		EndingStationName = endingStationName;
	}

	public String getStartingStationName() {
		return StartingStationName;
	}

	public void setStartingStationName(String startingStationName) {
		StartingStationName = startingStationName;
	}

	private String Seat = null;

	public String getSerno() {
		return Serno;
	}

	public void setSerno(String serno) {
		Serno = serno;
	}

	public String getTrainNumber() {
		return TrainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		TrainNumber = trainNumber;
	}

	public String getMserno() {
		return Mserno;
	}

	public void setMserno(String mserno) {
		Mserno = mserno;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getStation() {
		return Station;
	}

	public void setStation(String station) {
		Station = station;
	}

	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}

	public String getArrivalsTime() {
		return ArrivalsTime;
	}

	public void setArrivalsTime(String arrivalsTime) {
		ArrivalsTime = arrivalsTime;
	}

	public String getSeat() {
		return Seat;
	}

	public void setSeat(String seat) {
		Seat = seat;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
