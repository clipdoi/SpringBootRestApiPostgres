package com.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "account", catalog = "postgres")
public class Account implements java.io.Serializable {

	private Integer id;
	private Role role;
	private String username;
	private String password;
	private String fullName;
	private String email;
	private boolean activated;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date created;
	private Set<Orders> orders = new HashSet<Orders>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public Account() {
	}

	public Account(Role role, String username, String password, String fullName, String email, boolean activated, Date created) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.activated = activated;
		this.created = created;
	}

	public Account(Role role, String username, String password, String fullName, String email, boolean activated,
			Date created, Set<Orders> orders, Set<Product> products) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.activated = activated;
		this.created = created;
		this.orders = orders;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "username", nullable = false, length = 200)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 250)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "fullname", nullable = false, length = 150)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "email", nullable = false, length = 250)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "activated", nullable = false)
	public boolean isActivated() {
		return this.activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 10)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Orders> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
