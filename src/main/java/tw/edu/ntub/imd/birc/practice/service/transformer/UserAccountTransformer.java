package tw.edu.ntub.imd.birc.practice.service.transformer;

import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;
import tw.edu.ntub.imd.birc.practice.dto.UserAccountDto;

@Component
public class UserAccountTransformer implements BeanEntityTransformer<UserAccountDto, UserAccount> {
    @Override
    public UserAccount transferToEntity(UserAccountDto userAccountDto) {
        return JavaBeanUtils.copy(userAccountDto, new UserAccount());
    }

    @Override
    public UserAccountDto transferToBean(UserAccount userAccount) {
        return JavaBeanUtils.copy(userAccount, new UserAccountDto());
    }
}
