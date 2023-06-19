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

import com.example.domain.Task;
import com.example.domain.User;

@Repository
public class TaskRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Task> TASK_ROW_MAPPER = new BeanPropertyRowMapper<>(Task.class);

	public List<Task> findAll(Integer userId) {
		String sql = "SELECT id, content, date, status, user_id FROM tasks WHERE user_id = :userId ORDER BY date DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		List<Task> taskList = template.query(sql, param, TASK_ROW_MAPPER);

		return taskList;
	}

	public void insert(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "INSERT INTO tasks(content, date, status, user_id) VALUES(:content, :date, :status, :userId);";
		template.update(sql, param);
	}
}
