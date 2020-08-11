package object.handler.objects;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.api.interfaces.IResources;

public class User implements IResources {

	private long id;
	private String firstname;
	private String surname;
	private String email;
	private String phone;
	private String username;
	private String password;
	private String joined;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getJoined() {
		return joined;
	}

	public void setJoined(String joined) {
		this.joined = joined;
	}

	@Override
	public void bind(ResultSet rs) throws SQLException {
		while (rs.next()) {
			setId(rs.getLong("id"));
			setFirstname(rs.getString("firstname"));
			setSurname(rs.getString("surname"));
			setEmail(rs.getString("email"));
			setPhone(rs.getString("phone"));
			setUsername(rs.getString("username"));
			setPassword(rs.getString("password"));
			setJoined(rs.getString("joined"));
		}
	}
}
