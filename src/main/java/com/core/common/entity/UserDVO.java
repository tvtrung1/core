package com.core.common.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.common.enums.ERole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDVO extends BaseDVO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	private long roleId;
	
	@Transient
	@Enumerated(EnumType.STRING)
	private ERole roleName;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String sex;
}
