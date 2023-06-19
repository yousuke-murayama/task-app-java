package com.example.form;

import jakarta.validation.constraints.NotBlank;

public class UserForm {

	private Integer id;
	@NotBlank(message = "名前は必須です")
	private String name;
	@NotBlank(message = "メールアドレスは必須です")
	private String email;
	@NotBlank(message = "郵便番号は必須です")
	private String zipcode;
	@NotBlank(message = "県は必須です")
	private String prefecture;
	@NotBlank(message = "市町村は必須です")
	private String city;
	@NotBlank(message = "番地は必須です")
	private String address;
	@NotBlank(message = "電話番号は必須です")
	private String tel;
	@NotBlank(message = "パスワードは必須です")
	private String password;
	@NotBlank(message = "確認用パスワードは必須です")
	private String passwordConfirmation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", name=" + name + ", email=" + email + ", zipcode=" + zipcode + ", prefecture="
				+ prefecture + ", city=" + city + ", address=" + address + ", tel=" + tel + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + "]";
	}

}
