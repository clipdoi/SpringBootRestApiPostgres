package com.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OrderdetailsId implements java.io.Serializable {

	@Column(name = "orderid", nullable = false)
	private int orderId;

	@Column(name = "productid", nullable = false)
	private int productId;

}
