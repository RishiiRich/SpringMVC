package com.spring.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.User;

public class UserDAO {

     private JdbcTemplate jdbctemplate;
	
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	
	public List<User> getUser(User u)
	{
		List<User> user=jdbctemplate.query("select * from user where name='"+u.getName()+"' and password='"+u.getPwd()+"'", new RowMapper<User>() 
		
			{
		

			@Override
			public User mapRow(ResultSet rs, int rowcount) throws SQLException {
				// TODO Auto-generated method stub
				User u=new User();
				u.setName(rs.getString(1));
				u.setPwd(rs.getString(2));
				return u;
				
				
			}
		});
		return user;
	}
}
