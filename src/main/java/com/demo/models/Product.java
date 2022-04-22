package com.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product", schema = "public")
public class Product implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid", nullable = false)
	private Account account;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryid", nullable = false)
	private Category category;

	@Column(name = "name", nullable = false, length = 60)
	private String name;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "price", nullable = false, precision = 17, scale = 17)
	private double price;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "status", nullable = false)
	private boolean status;

	@Column(name = "activated", nullable = false)
	private boolean activated;

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 13)
	private Date created;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<Orderdetails> orderDetails = new HashSet<>();


}
