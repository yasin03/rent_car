package com.backend.rentcar.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 15)
	@NotNull(message = "Please enter your first name")
	@Column(nullable = false, length = 15)
	private String firstName;
	
	@Size(max = 15)
	@NotNull(message = "Please enter your last name")
	@Column(nullable = false, length = 15)
	private String lastName;
	
	@Size(min=4, max=60, message = "Please enter min 4 characters")
	@NotNull(message = "Please enter your password")
	@Column(nullable = false, length = 120)
	private String password;
	
	@Pattern(regexp = "^((\\\\(\\\\d{3}\\\\))|\\\\d{3})[- .]?\\\\d{3}[- .]?\\\\d{4}$",
			message = "Please enter valid phone number")
	@Size(min = 14,max = 14, message = "Phone number should be exact 10 characters")
	@NotNull(message = "Please enter your phone number")
	@Column(nullable = false, length = 14)
	private String phoneNumber;
	
	@Email(message = "Please enter valid email")
	@Size(min = 5, max=150)
	@NotNull(message = "Please enter your email")
	@Column(nullable = false, unique = true, length = 150)
	private String email;
	
	@Size(max = 250)
	@NotNull(message = "Please enter your address")
	@Column(nullable = false, length = 250)
	private String adress;
	
	@Size(max = 15)
	@NotNull(message = "Please enter your zip code")
	@Column(nullable = false, length = 15)
	private String zipCode;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name ="role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@Column(nullable = false)
	private Boolean builtIn;

	public User(String firstName, String lastName, String password, String phoneNumber, String email, String adress,
			String zipCode) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.adress = adress;
		this.zipCode = zipCode;
	}

	public User(String firstName, String lastName, String password, String phoneNumber, String email, String adress,
			String zipCode, Set<Role> roles, Boolean builtIn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.adress = adress;
		this.zipCode = zipCode;
		this.roles = roles;
		this.builtIn = builtIn;
	}
	
	public String getFullName() {
		return firstName + " "+lastName;
	}
	
	public Set<Role> getRole(){
		return roles;
	}
	
	public Set<String> getRoles(){
		
		Set<String> roles1 = new HashSet<>();
		Role[] role = roles.toArray(new Role[roles.size()]);
		
		for (int i = 0; i < roles.size(); i++) {

		}
		
		return roles1;
	}
	
	
	
	
}
