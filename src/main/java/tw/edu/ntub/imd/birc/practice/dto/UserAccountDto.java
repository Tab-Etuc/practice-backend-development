package tw.edu.ntub.imd.birc.practice.dto;

import lombok.Data;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.enumerate.UserRole;

import java.time.LocalDateTime;

@Data
public class UserAccountDto {
    private Integer sno;
    @com.fasterxml.jackson.annotation.JsonAlias("username")
    private String name;
    private String email;
    private String account;
    private String password;
    private String avilable;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String identity;

    public Boolean getIsStudent() {
        return UserRole.getRolesBySystemId(identity).contains(UserRole.STUDENT);
    }

    public Boolean getIsManager() {
        return UserRole.getRolesBySystemId(identity).stream().anyMatch(UserRole::isManager);
    }
}
