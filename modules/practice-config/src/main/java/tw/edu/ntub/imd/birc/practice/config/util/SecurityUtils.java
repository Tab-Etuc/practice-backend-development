package tw.edu.ntub.imd.birc.practice.config.util;

import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtils {
    public static final Integer REFRESH_HOUR = 168;
    private static final String ADMIN_ROLES = "'母系統管理員','助教','管理員'";
    public static final String HAS_ANY_ADMIN_AUTHORITY = "hasAnyAuthority(" + ADMIN_ROLES + ")";
    public static final String HAS_ANY_ADMIN_OR_STUDENT_AUTHORITY = "hasAnyAuthority(" + ADMIN_ROLES + ",'學生')";

    private SecurityUtils() {

    }

    public static String getLoginUserAccount() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static String getLoginUserIdentity() {
        return String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    }

    public static boolean isLogin() {
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }
}
