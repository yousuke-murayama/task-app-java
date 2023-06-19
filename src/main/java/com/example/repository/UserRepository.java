package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<User> USER_ROW_MAPPER = new BeanPropertyRowMapper<>(User.class);
	
	public List<User> findAll() {
		String sql = "SELECT id, name, email, zipcode, prefecture, city, address, tel, password FROM users ORDER BY id;";
		
		List<User> userList = template.query(sql, USER_ROW_MAPPER);
		
		return userList;
	}
	
	public User findByEmail(String email) {
		String sql = "SELECT id, name, email, zipcode, prefecture, city, address, tel, password FROM users "
				+ " WHERE email = :email;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		
		if(userList.size() == 0) {
			return null;
		}
		
		return userList.get(0);
	}
	
	public void insert(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		
		String sql = "INSERT INTO users(name, email, zipcode, prefecture, city, address, tel, password) "
				+ " VALUES(:name, :email, :zipcode, :prefecture, :city, :address, :tel, :password);";
		
		template.update(sql, param);
	}
	
}
