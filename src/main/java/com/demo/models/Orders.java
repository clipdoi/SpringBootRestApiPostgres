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
@Table(name = "orders", schema = "public")
public class Orders implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid", nullable = false)
	private Account account;

	@Temporal(TemporalType.DATE)
	@Column(name = "orderdate", nullable = false, length = 13)
	private Date orderdate;

	@Column(name = "address", nullable = false, length = 250)
	private String address;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "phone", nullable = false, length = 40)
	private String phone;

	@Column(name = "status", nullable = false)
	private short status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	private Set<Orderdetails> orderdetailses = new HashSet<Orderdetails>(0);

	public Orders(int id, Account account, Date orderdate, String address, String description, String phone,
                  short status) {
		this.id = id;
		this.account = account;
		this.orderdate = orderdate;
		this.address = address;
		this.description = description;
		this.phone = phone;
		this.status = status;
	}










}
