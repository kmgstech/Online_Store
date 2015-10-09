package com.grocery;

public class Services 

{
	private String f_name;
	private String l_name;
	private String username;
	private String pass;
	private long ph_no;
	private int age;
	private String address;
	private String city;
	private String image;
	private String experience;
	private String refferal;
	
	public void setFname(String f_name)
	{
		this.f_name=f_name;
	}
	public void setLname(String l_name)
	{
		this.l_name=l_name;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setPass(String pass)
	{
		this.pass=pass;
	}
	public void setPhone_no(long ph_no)
	{
		this.ph_no=ph_no;
		
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public void setImage(String image)
	{
		this.image=image;
		
	}
	public String getImage()
	{
		return image;
	}
	public void setExp(String experience)
	{
		this.experience=experience;
	}
	public void setRef(String refferal)
	{
		this.refferal=refferal;
	}
	public String getFname()
	{
		return f_name;
	}
	public String getLname()
	{
		return l_name;
	}
	public String getUsername()
	{
		return username;		
	}
	public String getPass()
	{
		return pass;
	}
	public long getPhone_no()
	{
		return ph_no;
	}
	public int getAge()
	{
		return age;
	}
	public String getAddress()
	{
		return address;
	}
	public String getCity()
	{
		return city;
	}
	public String getExp()
	{
		return experience;
	}
	public String getRef()
	{
		return refferal;
	}                                  
}
