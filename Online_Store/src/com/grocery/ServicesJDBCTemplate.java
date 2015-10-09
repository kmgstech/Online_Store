package com.grocery;

import javax.sql.DataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Types;
import java.util.List;
import java.util.Scanner;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

public class ServicesJDBCTemplate implements ServiceDAO
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	private Services serObj; 
	
	
	public void setDataSource(DataSource datasource)
	{
		this.dataSource=datasource;
		this.jdbcTemplateObject=new JdbcTemplate(dataSource);		
	}
	public void create(String f_name,String l_name,String username,String pass, long ph_no, int age,String address,String city,String experience,String refferal)
	{
		input();
		
		//  image code starts Here *********************
		try
		{
		final File blobIn = new File("D:\\download.jpg");
		final InputStream blobIs = new FileInputStream(blobIn);
		LobHandler lobHandler = new DefaultLobHandler();
		
			String SQL=
					"insert into service_provider (image, f_name,l_name,username,pass,ph_no,age,address,city,experience,refferal) values(?,?,?,?,?,?,?,?,?,?,?)";
			
			jdbcTemplateObject.update(SQL, new Object[] {
					new SqlLobValue(blobIs, (int)blobIn.length(), lobHandler), 
					
					// f_name,l_name,username,pass,ph_no,age,address,city,experience,refferal},
					
					serObj.getFname(),serObj.getLname(),serObj.getUsername(),serObj.getPass(),
					serObj.getPhone_no(),serObj.getAge(),serObj.getAddress(),
					serObj.getCity(),serObj.getExp(),serObj.getRef()},
					new int[] {	Types.BLOB,
							   	Types.VARCHAR,
							   	Types.VARCHAR,
							   	Types.VARCHAR,
							   	Types.VARCHAR,
							   	Types.BIGINT,
							   	Types.INTEGER,
							   	Types.VARCHAR,
							   	Types.VARCHAR,
							   	Types.VARCHAR,
							   	Types.VARCHAR,
			} );

		  }
		catch (DataAccessException e) {
		   System.out.println("DataAccessException " + e.getMessage());
		  } catch (FileNotFoundException e) {
		   System.out.println("DataAccessException " + e.getMessage());
		  }
		catch(NullPointerException e)
		{
			System.out.println("Null Pointer Exception" + e.getMessage());
		};
	 
		 // *******************image code ends Here
		
		System.out.println("Created Records: First Name=" +f_name+
				"Last Name=" +l_name+ "Username="+username+ 
				"Password="+pass+ "Phone No.=" +ph_no+
				"Age=" +age+ "Address=" +address+ "City=" +city+
				"Experience=" +experience+ "Referrence=" +refferal);
			
	}
	
	public void input()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the First Name");
		String f_name=sc.next();
		
		System.out.println("Enter the Last Name");
		String l_name=sc.next();
		
		System.out.println("Enter the User Name");
		String username=sc.next();
		
		System.out.println("Enter the Password");
		String pass=sc.next();
		
		System.out.println("Enter the Phone Number");
		long ph_no=sc.nextLong();
		
		System.out.println("Enter the Age");
		Integer age=sc.nextInt();
		
		System.out.println("Enter the Address");
		String address=sc.next();
		
		System.out.println("Enter the City Name");
		String city=sc.next();
		
		System.out.println("Enter the Experience");
		String experience=sc.next();
		
		System.out.println("Enter the Refferal");
		String refferal=sc.next();
				
		
		
		serObj = new Services();
		
		serObj.setFname(f_name);
		serObj.setLname(l_name);
		serObj.setUsername(username);
		serObj.setPass(pass);
		serObj.setPhone_no(ph_no);
		serObj.setAge(age);
		serObj.setAddress(address);
		serObj.setCity(city);
		serObj.setExp(experience);
		serObj.setRef(refferal);
		
		sc.close();
		
	}
	/*public void insertImage()
	{
		try
		{
		final File blobIn = new File("D:\\download.jpg");
		final InputStream blobIs = new FileInputStream(blobIn);
		LobHandler lobHandler = new DefaultLobHandler();
		
		 jdbcTemplateObject.update(
		         "INSERT INTO service_provider (image) VALUE(?)",
		         new Object[] {
		             new SqlLobValue(blobIs, (int)blobIn.length(), lobHandler),
		         },
		         new int[] {Types.BLOB});
		   
		  } catch (DataAccessException e) {
		   System.out.println("DataAccessException " + e.getMessage());
		  } catch (FileNotFoundException e) {
		   System.out.println("DataAccessException " + e.getMessage());
		  }
		
	}
	*/
	public Services getService(String username)
	{
		String SQL="select * from service_provider where username=?";
		Services services=
				jdbcTemplateObject.queryForObject(SQL,new Object[]{username},new ServiceMapper());
		return services;
	}
	
	public void delete(String username)
	{
		String SQL="delete from service_provider where username=?";
		jdbcTemplateObject.update(SQL,username);
		System.out.println("Deleted record is->" +username);
		return;
		
	}
	public List<Services> listServices()
	{
		String SQL=
				"select * from service_provider";
		List<Services> services=
				jdbcTemplateObject.query(SQL, new ServiceMapper());
		return services;
				
	}
	
	public void update(String username,String f_name)
	{
		String SQL="update service_provider set f_name=? where username=?";
		jdbcTemplateObject.update(SQL,f_name,username);
		System.out.println("Upadated Record with username="+username);
		return;		
	}
	
}
