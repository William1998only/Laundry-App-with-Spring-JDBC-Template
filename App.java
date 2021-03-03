package com.lawencon.laundry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lawencon.laundry.view.MainView;

/**
 * 
 * @author WILLIAM
 *
 */
public class App {
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
		MainView main = context.getBean("main", MainView.class);
		main.showMenuUtama();
		((ClassPathXmlApplicationContext)context).close();
	}
}
