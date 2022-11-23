package com.core.common.repo.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.core.common.entity.UserDVO;
import com.core.common.repo.UserCustomRepo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserCustomerRepoImpl implements UserCustomRepo {

	private final EntityManager em;
	
	@Override
	public Optional<UserDVO> findByUserName(String userName) {
		// TODO Auto-generated method stub
		String sql = "Select u.userId,u.roleName,u. from UserDVO u Join RoleDVO r on u.roleId = r.roleId";
		return null;
	}

}
