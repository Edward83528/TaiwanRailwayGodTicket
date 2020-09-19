package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
@RequestMapping("/HelloWeb")
public class OrderListController {
	public static void main(String[] args) {

	}

	@RequestMapping(value = "/order-1", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("order-1", "command", new OrderList());
	}

	// 搜尋車站導向自己
	@RequestMapping(value = "/station", method = RequestMethod.POST)
	public String station(@ModelAttribute("SpringWeb") OrderList orderlist, ModelMap model) {
		model.addAttribute("keyword", orderlist.getKeyword());
		return "foundStation";
	}

	@RequestMapping(value = "/addorder", method = RequestMethod.POST)
	public String addorder(@ModelAttribute("SpringWeb") OrderList orderlist, ModelMap model) {
		model.addAttribute("Twid", orderlist.getTwid());
		model.addAttribute("start", orderlist.getStart());
		model.addAttribute("end", orderlist.getEnd());
		model.addAttribute("trainid", orderlist.getTrainid());
		model.addAttribute("total", orderlist.getTotal());
		model.addAttribute("date", orderlist.getDate());
		model.addAttribute("type", orderlist.getType());
		model.addAttribute("check", orderlist.getCheck());
		return "order-2";
	}

	@RequestMapping(value = "/addorder2", method = RequestMethod.POST)
	public String addorder2(@ModelAttribute("SpringWeb") OrderList orderlist, ModelMap model) {
		boolean chekseats = true;
		boolean checkseat = true;
		// 增加屬性
		model.addAttribute("Twid", orderlist.getTwid());
		model.addAttribute("start", orderlist.getStart());
		model.addAttribute("end", orderlist.getEnd());
		model.addAttribute("trainid", orderlist.getTrainid());
		model.addAttribute("total", orderlist.getTotal());
		model.addAttribute("date", orderlist.getDate());
		model.addAttribute("type", orderlist.getType());
		model.addAttribute("TrainNumber", orderlist.getTrainNumber());
		model.addAttribute("TrainTypeName", orderlist.getTrainTypeName());
		model.addAttribute("ArrivalTime", orderlist.getArrivalTime());
		model.addAttribute("DepartureTime", orderlist.getDepartureTime());
		SelectTrainCode addOder = new SelectTrainCode();
		// 查出這個班次的座位
		ArrayList<Station_trainItem> lists = addOder.SelectTrainSeat(orderlist.getTrainid());
		// seats為要存進訂票紀錄的where欄位
		String seats = "2A9";
		if (lists != null && lists.size() > 0) {
			Map<String, String> seat = lists.get(0).getSeat();
			for (int i = 1; i < 3; i++) {
				for (int j = 1; j < 11; j++) {
					String item = seat.get("" + i + "A" + j);
					if (item.equals("N")) {
						seat.put("" + i + "A" + j, "Y");
						seats = "" + i + "A" + j;
						checkseat = false;
						break;
					}
				}
			}
			// 把座位從N變Y更新
			addOder.UpdateTrains(orderlist.getTrainid(), seat);

		}
		// 查詢訂票紀錄 這個車次的這個座位有沒有人座,有人座傳回true,沒人做傳回false並成功訂票
		if (addOder.checkseatitem(orderlist.getTrainid(), seats)) {
			// if (checkseat) {
			System.out.print("跑1跑");
			// 查詢佔據那個位置的人,是從哪裡到哪裡
			String Seatcheck = addOder.checkSeat(orderlist.getTrainid(), seats);
			String s1 = "";
			String s2 = "";
			int index = Seatcheck.indexOf("_");
			if (!Seatcheck.equals("")) {
				if (index > 1) {
					s1 = Seatcheck.substring(0, 2);
					s2 = Seatcheck.substring(3, 5);
				} else {
					s1 = Seatcheck.substring(0, 1);
					s2 = Seatcheck.substring(2, 1);
				}
			}
			// 民眾搭的起始站順序值 在跟佔據那個人的 順序值做比較
			int startindex = Integer.parseInt(addOder.checkSeatindex(orderlist.getTrainid(), orderlist.getStart()));
			if ((Integer.parseInt(s1) < startindex && startindex < Integer.parseInt(s2))
					|| (Integer.parseInt(s1) > startindex && startindex < Integer.parseInt(s2))) {
				chekseats = false;
			}

			if (chekseats) {
				String whereStart = addOder.whereStart(orderlist.getTrainid(), orderlist.getStart());
				String whereEnd = addOder.whereStart(orderlist.getTrainid(), orderlist.getEnd());
				model.addAttribute("seats", "no");
				boolean check = addOder.AddOrderRecord(orderlist.getTwid(), whereStart + "_" + whereEnd, "no",
						orderlist.getTotal(), orderlist.getTrainid(), orderlist.getArrivalTime(),
						orderlist.getDepartureTime(), orderlist.getStart(), orderlist.getEnd());
				try {

					if (check) {
						model.addAttribute("messages", "系統:請您在台北站移駕至到3車8號");
						return "order-3";
					} else {
						model.addAttribute("messages", "您已經訂過票,不能重複訂票");
						return "message";
					}

				} catch (Exception e) {
					model.addAttribute("messages", "系統出錯");
					return "message";
				}
			} else {
				model.addAttribute("messages", "目前沒位置");
				return "message";
			}
		} else {
			System.out.print("跑2跑");
			String whereStart = addOder.whereStart(orderlist.getTrainid(), orderlist.getStart());
			String whereEnd = addOder.whereStart(orderlist.getTrainid(), orderlist.getEnd());
			model.addAttribute("seats", seats);
			boolean check = addOder.AddOrderRecord(orderlist.getTwid(), whereStart + "_" + whereEnd, seats,
					orderlist.getTotal(), orderlist.getTrainid(), orderlist.getArrivalTime(),
					orderlist.getDepartureTime(), orderlist.getStart(), orderlist.getEnd());
			try {

				if (check) {
					if (orderlist.getTwid().equals("L125010351")) {
						model.addAttribute("messages", "請您在新竹站移駕至到3車8號");
						return "order-3";
					} else {
						model.addAttribute("messages", "");
						return "order-3";
					}
				} else {
					model.addAttribute("messages", "您已經訂過票,不能重複訂票");
					return "message";
				}

			} catch (Exception e) {
				model.addAttribute("messages", "系統出錯");
				return "message";
			}
		}
	}

	// 退票表單頁面
	@RequestMapping(value = "/addrefund", method = RequestMethod.POST)
	public String addrefund(@ModelAttribute("SpringWeb") OrderList orderlist, ModelMap model) {
		model.addAttribute("twid", orderlist.getTwid());
		return "refund-2";
	}

	// 退票成功送出刪除紀錄
	@RequestMapping(value = "/addrefund2", method = RequestMethod.POST)
	public String addrefund2(@ModelAttribute("SpringWeb") OrderList orderlist, ModelMap model) {
		model.addAttribute("twid", orderlist.getTwid());
		SelectTrainCode addOder = new SelectTrainCode();
		ArrayList<Station_trainItem> lists = addOder.SelectTrainSeat(orderlist.getTrainNumber());

		if (lists != null && lists.size() > 0) {
			Map<String, String> seat = lists.get(0).getSeat();
			for (int i = 1; i < 3; i++) {
				for (int j = 1; j < 11; j++) {
					String item = seat.get("" + i + "A" + j);
					if (item.equals("Y")) {
						seat.put("" + i + "A" + j, "N");
						break;
					}
				}
			}
			addOder.UpdateTrains(orderlist.getTrainNumber(), seat);
		}

		SelectTrainCode DeleteOder = new SelectTrainCode();
		DeleteOder.DelOrderRecord(orderlist.getTwid());
		model.addAttribute("messages", "取消成功");
		return "message";
	}

	// 查詢車次表單傳送
	@RequestMapping(value = "/selectTrain", method = RequestMethod.POST)
	public String selectTrain(@ModelAttribute("SpringWeb") SelectList selectList, ModelMap model) {
		model.addAttribute("Start", selectList.getStart());
		model.addAttribute("End", selectList.getEnd());
		model.addAttribute("date", selectList.getDate());
		return "search-2";
	}

	// 導向撈車次資料ajax
	@RequestMapping(value = "/getTraindata", method = RequestMethod.POST)
	public String getTraindata(@ModelAttribute("SpringWeb") OrderList orderlist, ModelMap model) {
		model.addAttribute("twid", orderlist.getTwid());
		model.addAttribute("start", orderlist.getStart());
		model.addAttribute("end", orderlist.getEnd());
		model.addAttribute("trainid", orderlist.getTrainid());
		model.addAttribute("total", orderlist.getTotal());
		model.addAttribute("date", orderlist.getDate());
		model.addAttribute("type", orderlist.getType());
		return "getTraindata";
	}

	// 導向撈車站資料ajax
	@RequestMapping(value = "/getStationdata", method = RequestMethod.POST)
	public String getStationdata(@ModelAttribute("SpringWeb") OrderList orderlist, ModelMap model) {
		model.addAttribute("areas", orderlist.getAreas());
		return "getStationdata";
	}

	// 導向撈車站資料ajax
	@RequestMapping(value = "/getStationdata2", method = RequestMethod.POST)
	public String getStationdata2(@ModelAttribute("SpringWeb") OrderList orderlist, ModelMap model) {
		model.addAttribute("areas", orderlist.getAreas2());
		return "getStationdata2";
	}

	// 寄出信件
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String send(@ModelAttribute("SpringWeb") EmailItem email, ModelMap model) {
		String msubject = "台鐵神票手民眾投訴信-" + email.getSubject();
		String mcontent = "<html><head><title>" + msubject
				+ "</title><meta http-equiv=Content-Type content='text/html; charset=UTF-8' />";
		mcontent += "<style>.font1 {font-family: Arial, Helvetica, sans-serif;font-size:100%;line-height:18px;font-weight: normal;color:#000000;text-decoration:none;}</style></head>";
		mcontent += "<body bgcolor=#FFFFFF text=#FFFFFF><div align=center>";
		mcontent += "<table border=0 align=center>";
		mcontent += "<tr><td>&nbsp;</td></tr>";
		mcontent += "<tr><td>&nbsp;</td></tr>";
		mcontent += "<tr><td class='font1' align='left'>" + "姓名:" + email.getName() + "</td></tr>";
		mcontent += "<tr><td class='font1' align='left'>" + "連絡電話:" + email.getPhone() + "</td></tr>";
		mcontent += "<tr><td class='font1' align='left'>" + "連絡信箱:" + email.getEmail() + "</td></tr>";
		mcontent += "<tr><td class='font1' align='left'>" + "留言:" + email.getContent() + "</td></tr>";
		mcontent += "</table></body></html>";
		model.addAttribute("email", email.getEmail());
		CmpMail mail = new CmpMail();
		mail.sendHtml("smtp.gmail.com", Integer.parseInt("587"), "u6923036@gmail.com", "zxcvbnm03510351",
				"u0151051@gmail.com", "", "", msubject, mcontent);
		model.addAttribute("messages", "寄信成功");
		return "message";
	}

}