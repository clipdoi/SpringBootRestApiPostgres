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
@Table(name = "product", schema = "public")
public class Product implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid", nullable = false)
	private Account account;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<Orderdetails> orderdetailses = new HashSet<Orderdetails>(0);

	public Product(int id, Account account, Category category, String name, int quantity, double price,
                   String description, boolean status, boolean activated, Date created) {
		this.id = id;
		this.account = account;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.status = status;
		this.activated = activated;
		this.created = created;
	}

}
