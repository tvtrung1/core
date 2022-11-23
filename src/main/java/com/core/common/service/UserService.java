package com.core.common.service;

import java.util.Optional;

import com.core.common.entity.UserDVO;

public interface UserService {
	Optional<UserDVO> findByUserName(String userName);
	
	Boolean existsByUserName(String userName);
	
	Boolean existsByEmail(String email);
	
	Optional<UserDVO> findUserByUsername(String userName);
	
	void save(UserDVO userDVO);
}
