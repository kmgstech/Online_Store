package com.grocery;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class ServiceMapper implements RowMapper<Services>
{
	public Services mapRow(ResultSet rs,int rownum) throws SQLException
	{
		Services services=new Services();
		services.setFname(rs.getString("f_name"));
		services.setLname(rs.getString("l_name"));
		services.setUsername(rs.getString("username"));
		services.setPass(rs.getString("pass"));
		services.setPhone_no(rs.getLong("ph_no"));
		services.setAge(rs.getInt("age"));
		services.setAddress(rs.getString("address"));
		services.setCity(rs.getString("city"));
		services.setImage(rs.getString("image"));
		services.setExp(rs.getString("experience"));
		services.setRef(rs.getString("refferal"));
		return services;
	}
	
}
