package com.core.common.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseDVO {

	private Date createTime;
	
	private String createBy;
	
	private Date updateTime;
	
	private String updateBy;
}
