package tw.com.common;

import java.util.ArrayList;

public class ArrangeData {
	// 整理資料庫的車次資料
	public static void main(String[] args) {
		int k = 0;
		boolean check = true;
		boolean check2 = true;
		TrainData trainData = new TrainData();
		ArrayList<TrainItem> lists = trainData.SelectTrains();
		ArrayList<StationItem> lists2 = trainData.SelectStation();
		if (lists != null) {
			ArrayList<TrainItem> result = new ArrayList<TrainItem>();

			for (int i = 0; check2; i++) {
				check = true;
				TrainItem list = lists.get(i);
				System.out.println("車次:" + list.getTrain());
				System.out.println("-------------------");

				for (int j = k + 1; check; j++) {
					StationItem list2 = lists2.get(j);
					StationItem list3 = lists2.get(j + 1);
					System.out.println("車站" + list2.getOrder1() + ":" + list2.getStation());
					trainData.AddTrains(list.getTrain(), list.getCarclass(), list2.getStation(), list2.getDeptime(),
							list2.getArrtime());
					if (list3.getOrder1().equals("1")) {
						k = j;
						check = false;
						if (list.getTrain().equals("5694")) {
							check2 = false;
						}
					}
				}

			}
		}

	}

}
