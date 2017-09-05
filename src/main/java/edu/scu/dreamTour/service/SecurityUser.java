package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.domain.security.SysRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: Security使用的User
 * @Date: Create in 2017/9/4 21:36
 * @ModifyBy:
 */
public class SecurityUser extends MyUser implements UserDetails{
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    public SecurityUser(MyUser user){

        if (user!=null){
            this.setAccount(user.getAccount());
            this.setBirthDay(user.getBirthDay());
            this.setEmail(user.getEmail());
            this.setId_card(user.getId_card());
            this.setIsVolunteer(user.getIsVolunteer());
            this.setNickName(user.getNickName());
            this.setPassword(user.getPassword());
            this.setRealName(user.getRealName());
            this.setPortraitImageFilePath(user.getPortraitImageFilePath());
            this.setSex(user.getSex());
            this.setSysRoles(user.getSysRoles());
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<SysRole> userRoles = this.getSysRoles();

        SimpleGrantedAuthority authority;

        if (userRoles != null){
            for (SysRole role:
                 userRoles) {
                authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }

        return authorities;
    }

    @Override
    public String getUsername() {
        return super.getAccount();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
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
