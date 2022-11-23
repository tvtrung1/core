package com.core.common.repo;

import java.util.Optional;

import com.core.common.entity.UserDVO;

public interface UserCustomRepo {
	Optional<UserDVO> findByUserName(String userName);
}
