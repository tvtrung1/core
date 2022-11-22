package com.core.common.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.common.entity.UserDVO;

@Repository
public interface UserRepository extends JpaRepository<UserDVO, Long>{
	
	Optional<UserDVO> findByUsername(String userName);
	
	Boolean existsByUserName(String userName);
}
