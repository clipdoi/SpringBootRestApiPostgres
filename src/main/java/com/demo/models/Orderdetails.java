package com.demo.models;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orderdetails", catalog = "postgres")
public class Orderdetails implements java.io.Serializable {

	private OrderdetailsId id;
	private Orders orders;
	private Product product;
	private int quantity;
	private double amount;

	public Orderdetails() {
	}

	public Orderdetails(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Orderdetails(OrderdetailsId id, Orders orders, Product product, int quantity, double amount) {
		this.id = id;
		this.orders = orders;
		this.product = product;
		this.quantity = quantity;
		this.amount = amount;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "orderid", column = @Column(name = "orderid", nullable = false)),
			@AttributeOverride(name = "productid", column = @Column(name = "productid", nullable = false)) })
	public OrderdetailsId getId() {
		return this.id;
	}

	public void setId(OrderdetailsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid", nullable = false, insertable = false, updatable = false)
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "amount", nullable = false, precision = 22, scale = 0)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
