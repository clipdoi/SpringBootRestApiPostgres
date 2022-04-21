package com.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role", schema = "public")
public class Role implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<Account> accounts = new HashSet<Account>(0);

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
	}










}
