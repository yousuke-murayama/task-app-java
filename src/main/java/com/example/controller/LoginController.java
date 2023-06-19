package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.form.UserLoginForm;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@GetMapping("")
	public String toLogin(UserLoginForm form) {
		return "to-login";
	}

	@PostMapping("/login")
	public String login(@Validated UserLoginForm form, BindingResult result) {
		User user = userService.login(form.getEmail(), form.getPassword());

		if (user == null) {
			result.rejectValue("email", null, "パスワードまたはメールアドレスが間違っています");
		}

		if (result.hasErrors()) {
			return toLogin(form);
		}

		session.setAttribute("currentUser", user);

		return "redirect:/task/show-list";
	}

	@GetMapping("/to-signup")
	public String toSignup(UserForm form) {
		return "to-signup";
	}

	@PostMapping("/signup")
	public String signup(@Validated UserForm form, BindingResult result) {

		if (!(form.getPassword().equals(form.getPasswordConfirmation()))) {
			result.rejectValue("passwordConfirmation", null, "パスワードが一致していません");
		}

		if (result.hasErrors()) {
			return toSignup(form);
		}

		User user = new User();
		BeanUtils.copyProperties(form, user);

		userService.insert(user);

		return "redirect:/";

	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

}
