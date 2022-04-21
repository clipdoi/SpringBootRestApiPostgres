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
@Table(name = "orders", catalog = "postgres")
public class Orders implements java.io.Serializable {

	private Integer id;
	private Account account;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	private String address;
	private String description;
	private String phone;
	private boolean status;
	private Set<Orderdetails> orderdetailses = new HashSet<Orderdetails>(0);

	public Orders() {
	}

	public Orders(Account account, Date orderDate, String address, String description, String phone, boolean status) {
		this.account = account;
		this.orderDate = orderDate;
		this.address = address;
		this.description = description;
		this.phone = phone;
		this.status = status;
	}

	public Orders(Account account, Date orderDate, String address, String description, String phone, boolean status, Set<Orderdetails> orderdetailses) {
		this.account = account;
		this.orderDate = orderDate;
		this.address = address;
		this.description = description;
		this.phone = phone;
		this.status = status;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "orderdate", nullable = false, length = 10)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "address", nullable = false, length = 250)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "phone", nullable = false, length = 100)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<Orderdetails> getOrderdetailses() {
		return this.orderdetailses;
	}

	public void setOrderdetailses(Set<Orderdetails> orderdetailses) {
		this.orderdetailses = orderdetailses;
	}

}
