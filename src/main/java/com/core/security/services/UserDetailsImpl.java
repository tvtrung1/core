package com.core.security.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.core.common.entity.UserDVO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long userId;

	private String userName;

	private String email;

	@JsonIgnore
	private String password;

	private GrantedAuthority authorities;

	public static UserDetailsImpl build(UserDVO userDVO) {
		GrantedAuthority authorities = new SimpleGrantedAuthority(userDVO.getRoleName().name());
		
//		authorities = 
		
//		return new UserDetailsImpl(
//			userDVO.getUserId(),
//			userDVO.getUserName(),
//			userDVO.getEmail(),
//			userDVO.getPassword(),
//			authorities
//		);
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
