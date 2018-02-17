package com.bootdo.common.social.core.support;

import com.bootdo.domain.entity.SysRole;
import com.bootdo.domain.entity.SysUser;
import com.bootdo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** @author Deament
 * @date 2017/10/1 **/
@Repository
public class SocialLoginServiceImpl implements SocialUserDetailsService {

	@Autowired
	SysUserService sysUserService;

	// 社交登陆接口
	/** (non-Javadoc)
	 *
	 * @param userId
	 *            sys_userconnection 表的USERID */
	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		return buildUser(userId);
	}

	private SocialUserDetails buildUser(String userId) {
		// 根据用户名查找用户信息
		// 根据查找到的用户信息判断用户是否被冻结
        SysUser sysUser = sysUserService.getUserByUserID(userId);
		List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
		for (SysRole s : sysUser.getRoleList()) {
			auths.add(new SimpleGrantedAuthority(s.getName()));
		}
		auths.add(new SimpleGrantedAuthority("/common/signup"));
		return new SocialUserDetails() {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				return "1".equals(sysUser.getUserstatus());
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public String getUsername() {
				return sysUser.getUsername();
			}

			@Override
			public String getPassword() {
				return sysUser.getUserpassword();
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return auths;
			}

			@Override
			public String getUserId() {
				return sysUser.getId();
			}
		};
	}
}
