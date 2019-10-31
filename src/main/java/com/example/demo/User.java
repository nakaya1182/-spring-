package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
@Table(name="juusho_tbl")
@Where(clause = " flag = 0")

public class User{

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="名前")
	private String name;
	@Column(name="住所")
	private String add;
	@Column(name="電話番号")
	private String tel;
	@Column(name="flag")
	private Integer flag=0;
}
