package tw.edu.ntub.imd.birc.practice.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.practice.databaseconfig.dao.UserAccountDAO;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;

import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.enumerate.UserRole;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountDAO userAccountDAO;

    public UserDetailsServiceImpl(UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> userAccountOptional = userAccountDAO.findByAccount(username);
        UserAccount userAccount = userAccountOptional.orElseThrow(() -> new UsernameNotFoundException("帳號不存在"));

        String identityCode = userAccount.getIdentity();
        String role = "Visitor"; // Default to Visitor (0)
        try {
            int code = Integer.parseInt(identityCode);
            UserRole userRole = UserRole.of(code);
            role = userRole.getTypeName();
        } catch (NumberFormatException e) {
            // Default to Visitor if parsing fails
        }

        return User.builder()
                .username(userAccount.getAccount())
                .password(userAccount.getPassword())
                .authorities(role)
                .disabled(false)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .build();
    }
}
