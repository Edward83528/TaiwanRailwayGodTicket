package com.tutorialspoint;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tutorialspoint.NewsJDBCTemplate;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		NewsJDBCTemplate newsJDBCTemplate = (NewsJDBCTemplate) context.getBean("NewsJDBCTemplate");
		System.out.println("------新增資訊--------");
		// newsJDBCTemplate.create("a", "b", "c");
		System.out.println("-----查詢多筆資訊--------");
		List<News> news = newsJDBCTemplate.listNews();
		for (News record : news) {
			System.out.println("Subject : " + record.getSubject1());
			System.out.println("Content : " + record.getContent1());
			System.out.println("Date : " + record.getDate1());
			System.out.println("Link : " + record.getLink());
			System.out.println("Picture : " + record.getPicture());
			System.out.println("------------------");
		}
		System.out.println("----查詢單筆 with ID = 2 -----");
		News news2 = newsJDBCTemplate.getNews(2);
		System.out.print("Subject : " + news2.getSubject1());

	}

}
