package tw.edu.ntub.imd.birc.practice.config.provider;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private final UserDetailsService userDetailsService;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        setHideUserNotFoundExceptions(false);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        String account = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(account);

        if (!StringUtils.equals(userDetails.getPassword(), password)) {
            throw new AuthenticationServiceException("密碼錯誤");
        } else if (!userDetails.isEnabled()) {
            throw new AuthenticationServiceException("您的帳號已被停權");
        }

        return userDetails;
    }
}
