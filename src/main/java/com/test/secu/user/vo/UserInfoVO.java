package com.test.secu.user.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


class GrantedAuthority2 implements GrantedAuthority{
	@Override
	public String getAuthority() {
		return null;
	}
}

@Getter
@Setter
@ToString
public class UserInfoVO implements UserDetails{

	private int uiNum;
    private String uiName;
    private String uiId;
    private String uiPwd;
    private String uiMobile;
    private String uiEmail;
    private String uiBirth;
    private String uiRoles;
    private String credat;
    private String lmodat;
    private String active;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	Collection<GrantedAuthority> roles=new ArrayList<>();
    	String[] uiRolesArr=uiRoles.split(",");
    	for(String uiRole:uiRolesArr) {
    		roles.add(new SimpleGrantedAuthority(uiRole));
    	}
		return roles;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
