package com.core.common.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.common.entity.UserDVO;
import com.core.common.repo.UserCustomRepo;
import com.core.common.repo.UserRepository;
import com.core.common.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	UserCustomRepo customRepo;

	@Override
	public Optional<UserDVO> findByUserName(String userName) {
		return repository.findByUserName(userName);
	}

	@Override
	public Boolean existsByUserName(String userName) {
		return repository.existsByUserName(userName);
	}

	@Override
	public Optional<UserDVO> findUserByUsername(String userName) {
		return customRepo.findByUserName(userName);
	}

	@Override
	public Boolean existsByEmail(String email) {
		return repository.existsByEmail(email);
	}

	@Override
	public void save(UserDVO userDVO) {
		repository.save(userDVO);
	}

}
