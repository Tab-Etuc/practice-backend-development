package tw.edu.ntub.imd.birc.practice.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.practice.databaseconfig.dao.UserAccountDAO;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;
import tw.edu.ntub.imd.birc.practice.dto.UserAccountDto;
import tw.edu.ntub.imd.birc.practice.exception.NotFoundException;
import tw.edu.ntub.imd.birc.practice.service.UserAccountService;
import tw.edu.ntub.imd.birc.practice.service.transformer.UserAccountTransformer;

import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.enumerate.UserRole;
import tw.edu.ntub.imd.birc.practice.util.date.LocalDateTimeUtils;

@Service
public class UserAccountServiceImpl extends BaseServiceImpl<UserAccountDto, UserAccount, Integer>
        implements UserAccountService {
    private final UserAccountDAO userAccountDAO;
    private final UserAccountTransformer transformer;

    public UserAccountServiceImpl(UserAccountDAO userAccountDAO, UserAccountTransformer transformer) {
        super(userAccountDAO, transformer);
        this.userAccountDAO = userAccountDAO;
        this.transformer = transformer;
    }

    @Override
    public UserAccountDto register(UserAccountDto userAccountDto) {
        if (userAccountDAO.findByAccount(userAccountDto.getAccount()).isPresent()) {
            throw new RuntimeException("帳號已存在");
        }
        UserAccount userAccount = transformer.transferToEntity(userAccountDto);
        userAccount.setIdentity(UserRole.STUDENT.getValue().toString()); // Default 1 for Student
        userAccount.setCreateDate(LocalDateTimeUtils.now());
        userAccount.setModifyDate(LocalDateTimeUtils.now());
        // Password hashing should occur here if not plain text
        return transformer.transferToBean(userAccountDAO.save(userAccount));
    }

    @Override
    public UserAccountDto getUserIdentity(String account) {
        return userAccountDAO.findByAccount(account)
                .map(transformer::transferToBean)
                .orElseThrow(() -> new NotFoundException("User not found: " + account));
    }
}
