package com.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderdetails", schema = "public")
public class Orderdetails implements java.io.Serializable {

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "orderid", column = @Column(name = "orderid", nullable = false)),
			@AttributeOverride(name = "productid", column = @Column(name = "productid", nullable = false)) })
	private OrderdetailsId id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid", nullable = false, insertable = false, updatable = false)
	private Orders orders;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid", nullable = false, insertable = false, updatable = false)
	private Product product;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "amountperprd", precision = 17, scale = 17)
	private Double amountPerProduct;

}
