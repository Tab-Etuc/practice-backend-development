package tw.edu.ntub.imd.birc.practice.databaseconfig.dao;

import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;

import java.util.Optional;

@Repository
public interface UserAccountDAO extends BaseDAO<UserAccount, Integer> {
    Optional<UserAccount> findByAccount(String account);
}
