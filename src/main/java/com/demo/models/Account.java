package com.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account", schema = "public")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid", nullable = false)
	private Role role;

	@Column(name = "username", nullable = false, length = 100)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "fullname", nullable = false, length = 100)
	private String fullName;

	@Column(name = "email", nullable = false, length = 80)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 13)
	private Date created;

	@Column(name = "activated", nullable = false)
	private boolean activated;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Product> products = new HashSet<>();

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Orders> orders = new HashSet<>();

}
