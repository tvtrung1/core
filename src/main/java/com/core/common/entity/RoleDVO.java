package com.core.common.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.core.common.enums.ERole;

@Entity
@Table(name = "roles")
public class RoleDVO extends BaseDVO{
	
	@Id
	private String roleId;
	
	@Enumerated(EnumType.STRING)
	private ERole roleName;
}
