package com.core.common.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.common.enums.ERole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDVO extends BaseDVO{
	
	@Id
	private String roleId;
	
	@Enumerated(EnumType.STRING)
	private ERole roleName;
	
	@OneToMany(mappedBy = "role")
	private List<UserDVO> users;
}
