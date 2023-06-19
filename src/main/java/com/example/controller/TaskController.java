package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Task;
import com.example.domain.User;
import com.example.repository.TaskRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private HttpSession session;

	@GetMapping("/show-list")
	public String showList(Model model) {
		User currentUser = (User) session.getAttribute("currentUser");
		List<Task> taskList = taskRepository.findAll(currentUser.getId());

		model.addAttribute("taskList", taskList);

		return "show-list";

	}

}
