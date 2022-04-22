package com.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role", schema = "public")
public class Role implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<Account> accounts = new HashSet<>();

}
