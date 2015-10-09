package com.grocery;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.grocery.ServicesJDBCTemplate;

public class Main 
{
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		ApplicationContext context= new ClassPathXmlApplicationContext("MyServlet.xml");
		ServicesJDBCTemplate servicesJDBCTemplate=
				(ServicesJDBCTemplate)context.getBean("ServicesJDBCTemplate");
		
		System.out.println("<------------------------Records Creation---------------------------------->");
		
	 	servicesJDBCTemplate.create("Chote", "Roy","rishi91","070r", 94563781, 24, "Delhi", "city", "5", "Rohan");
	 	
		
		
		//servicesJDBCTemplate.insertImage();
		
		System.out.println("<------------------------Listing Multiple Records----------------------------------->");
		
		List<Services> services= servicesJDBCTemplate.listServices();
		for(Services record:services)
		{
			System.out.println("FirstName:"+record.getFname());
			System.out.println("LastName:"+record.getLname());
			System.out.println("Username:"+record.getUsername());
			System.out.println("Password:"+record.getPass());
			System.out.println("Phone_No:"+record.getPhone_no());
			System.out.println("Age:"+record.getAge());
			System.out.println("Address"+record.getAddress());
			System.out.println("City"+record.getCity());
			System.out.println("Experience"+record.getExp());
			System.out.println("Referral:"+record.getRef());
			
		}
		
		System.out.println("<-----------------------Deletion of Records with given username------------------------>");
		
		servicesJDBCTemplate.delete("dsd");
		
		System.out.println("<-----------------------Updation ------------------------>");
		
		servicesJDBCTemplate.update("rishi049", "Rishi");
		
	}

}
