package com.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account", schema = "public")
public class Account implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid", nullable = false)
	private Role role;

	@Column(name = "username", nullable = false, length = 100)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "fullname", nullable = false, length = 100)
	private String fullname;

	@Column(name = "email", nullable = false, length = 80)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 13)
	private Date created;

	@Column(name = "activated", nullable = false)
	private boolean activated;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Product> products = new HashSet<Product>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Orders> orderses = new HashSet<Orders>(0);

}
