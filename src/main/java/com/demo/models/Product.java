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
@Table(name = "product")
public class Product implements java.io.Serializable {

	private Integer id;
	private Account account;
	private Category category;
	private String name;
	private int quantity;
	private double price;
	private String description;
	private boolean status;
	private boolean activated;
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	private Date created;
	private Set<Orderdetails> orderdetailses = new HashSet<Orderdetails>(0);

	public Product() {
	}

	public Product(Account account, Category category, String name, int quantity,
				   double price, String description, boolean status, boolean activated, Date created) {
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

	public Product(Account account, Category category, String name, int quantity,
				   double price, String description,
				   boolean status, boolean activated, Date created, Set<Orderdetails> orderdetailses) {
		this.account = account;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.status = status;
		this.activated = activated;
		this.created = created;
		this.orderdetailses = orderdetailses;
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
	@JoinColumn(name = "accountid", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryid", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "activated", nullable = false)
	public boolean isActivated() {
		return activated;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Orderdetails> getOrderdetailses() {
		return this.orderdetailses;
	}

	public void setOrderdetailses(Set<Orderdetails> orderdetailses) {
		this.orderdetailses = orderdetailses;
	}

}
