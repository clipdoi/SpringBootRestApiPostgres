package com.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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
	private Double amountperprd;

}
