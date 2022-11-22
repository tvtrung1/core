package com.core.common.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.common.entity.RoleDVO;
import com.core.common.enums.ERole;

@Repository
public interface RoleRepository extends JpaRepository<RoleDVO, String>{

	Optional<RoleDVO> findByRoleName(ERole name);
}
