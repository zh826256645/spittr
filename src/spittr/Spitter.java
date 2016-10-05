package spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
	
	private Long id;
	
	// 非空
	@NotNull
	// 必须时 String 类型，最少5位，最大16位
	@Size(min=5, max=16, message="{username.size}")
	private String username;
	
	@NotNull
	@Size(min=5, max=25, message="{password.size}")
	private String password;

	@NotNull
	@Size(min=2, max=30, message="{firstName.size}")
	private String firstName;
	
	@NotNull
	@Size(min=2, max=30, message="{lastName.size}")
	private String lastName;
	
	private String email;

	public Spitter() {
		super();
	}

	public Spitter(String username, String password,String firstName, String lastName, String email) {
		this(null, username, password, firstName, lastName, email);
	}

	public Spitter(Long id, String username,String password, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Spitter [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}
}
