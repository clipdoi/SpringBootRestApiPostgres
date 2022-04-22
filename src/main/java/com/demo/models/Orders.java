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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders", schema = "public")
public class Orders implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid", nullable = false)
	private Account account;

	@Temporal(TemporalType.DATE)
	@Column(name = "orderdate", nullable = false, length = 13)
	private Date orderDate;

	@Column(name = "address", nullable = false, length = 250)
	private String address;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "phone", nullable = false, length = 40)
	private String phone;

	@Column(name = "status", nullable = false)
	private short status;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	private Set<Orderdetails> orderDetails = new HashSet<>();


}
