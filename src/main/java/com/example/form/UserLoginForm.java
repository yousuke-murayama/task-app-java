package com.example.form;

import jakarta.validation.constraints.NotBlank;

public class UserLoginForm {

	@NotBlank(message = "メールアドレスは必須です")
	private String email;
	@NotBlank(message = "パスワードは入力必須です")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginForm [email=" + email + ", password=" + password + "]";
	}

}
