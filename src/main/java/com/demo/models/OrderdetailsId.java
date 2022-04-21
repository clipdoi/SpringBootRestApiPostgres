package com.demo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OrderdetailsId implements java.io.Serializable {

	private int orderId;
	private int productId;

	public OrderdetailsId() {
	}

	public OrderdetailsId(int orderId, int productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	@Column(name = "orderid", nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "productid", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderdetailsId))
			return false;
		OrderdetailsId castOther = (OrderdetailsId) other;

		return (this.getOrderId() == castOther.getOrderId()) && (this.getProductId() == castOther.getProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrderId();
		result = 37 * result + this.getProductId();
		return result;
	}

}
