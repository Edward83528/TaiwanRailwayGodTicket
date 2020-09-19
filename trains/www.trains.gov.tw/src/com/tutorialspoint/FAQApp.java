package com.tutorialspoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FAQApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		FAQJDBCTemplate fAQJDBCTemplate = (FAQJDBCTemplate) context.getBean("FAQJDBCTemplate");
		// System.out.println("------新增資訊--------");
		// newsJDBCTemplate.create("a", "b", "c");
		System.out.println("-----查詢多筆資訊--------");
		List<FAQItem> faqs = fAQJDBCTemplate.listFAQ();
		for (FAQItem faq : faqs) {
			System.out.println("Question : " + faq.getQuestion());
			System.out.println("------------------");
		}
		// System.out.println("----查詢單筆 with ID = 2 -----");
		// News news2 = newsJDBCTemplate.getNews(2);
		// System.out.print("Subject : " + news2.getSubject1());

	}

}
