package com.demo.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class OrderdetailsId implements java.io.Serializable {

	@Column(name = "orderid", nullable = false)
	private int orderid;

	@Column(name = "productid", nullable = false)
	private int productid;

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderdetailsId))
			return false;
		OrderdetailsId castOther = (OrderdetailsId) other;

		return (this.getOrderid() == castOther.getOrderid()) && (this.getProductid() == castOther.getProductid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrderid();
		result = 37 * result + this.getProductid();
		return result;
	}

}
