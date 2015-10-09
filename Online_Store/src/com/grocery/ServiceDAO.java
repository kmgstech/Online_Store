package com.grocery;

import javax.sql.DataSource;
import java.util.List;

public interface ServiceDAO

{
	public void setDataSource(DataSource datasource);
	public void create(String f_name,String l_name,String username,String pass,long ph_no, int age,String address,String city,String experience,String refferal);
	public Services getService(String username);
	public List<Services> listServices();	
	//public void insertImage();
}
