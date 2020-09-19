package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@RequestMapping("/HelloWeb"),HelloWeb名稱要跟web.xml的<servlet-mapping>中一樣
@Controller
@RequestMapping("/HelloWeb")
public class HelloController {

	public static void main(String[] args) {

	}

	// value = "hello"為網址的名稱末端
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello你成功完成 Spring MVC ");
		return "hello";
	}

	// 返回首頁
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String backindex() {
		return "redirect:backmain";
	}

	@RequestMapping(value = "/backmain", method = RequestMethod.GET)
	public String backmain() {
		return "index";
	}

	// 導向order-1
	@RequestMapping(value = "/order1", method = RequestMethod.GET)
	@ExceptionHandler({ SpringException.class })
	public String order1() {
		return "redirect:orderview1";
	}

	@RequestMapping(value = "/orderview1", method = RequestMethod.GET)
	public String orderview1() {
		return "order-1";
	}

	// 導向order-2
	@RequestMapping(value = "/order2", method = RequestMethod.GET)
	public String order2() {
		return "redirect:orderview2";
	}

	@RequestMapping(value = "/orderview2", method = RequestMethod.GET)
	public String orderview2() {
		return "order-2";
	}

	// 導向more內頁(帶參數)
	@RequestMapping(value = "/more", method = RequestMethod.GET)
	public String more(@RequestParam("start") int start, Model model) {
		model.addAttribute("start", String.valueOf(start));
		return "more";
	}

	// 導向more內頁(帶參數)
	@RequestMapping(value = "/morefaq", method = RequestMethod.GET)
	public String morefaq(@RequestParam("start") int start, Model model) {
		model.addAttribute("start", String.valueOf(start));
		return "morefq";
	}

	// 導向more內頁(帶參數)
	@RequestMapping(value = "/morein", method = RequestMethod.GET)
	public String morein(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
		return "news";
	}

	// 導向more內頁(帶參數)
	@RequestMapping(value = "/moreinfaq", method = RequestMethod.GET)
	public String moreinfaq(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
		return "faq";
	}

	// 導向退票
	@RequestMapping(value = "/refund1", method = RequestMethod.GET)
	public String refund1() {
		return "redirect:refund1view";
	}

	@RequestMapping(value = "/refund1view", method = RequestMethod.GET)
	public String refund1view() {
		return "refund-1";
	}

	// 導向search1
	@RequestMapping(value = "/search1", method = RequestMethod.GET)
	public String search1() {
		return "redirect:searchview1";
	}

	@RequestMapping(value = "/searchview1", method = RequestMethod.GET)
	public String searchview1() {
		return "search-1";
	}

	// 導向search2
	@RequestMapping(value = "/search2", method = RequestMethod.GET)
	public String search2() {
		return "redirect:searchview2";
	}

	@RequestMapping(value = "/searchview2", method = RequestMethod.GET)
	public String searchview2() {
		return "search-2";
	}

	// 導向foundStation
	@RequestMapping(value = "/Found", method = RequestMethod.GET)
	public String Found(@RequestParam("start") int start, Model model) {
		model.addAttribute("start", String.valueOf(start));
		return "foundStation";
	}

	// 導向局長信箱
	@RequestMapping(value = "/Email", method = RequestMethod.GET)
	public String Email() {
		return "redirect:Emailview";
	}

	@RequestMapping(value = "/Emailview", method = RequestMethod.GET)
	public String Emailview() {
		return "mailbox";
	}

	// 導向車站內頁(帶參數)
	@RequestMapping(value = "/stationin", method = RequestMethod.GET)
	public String stationin(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
		return "station_train";
	}

}