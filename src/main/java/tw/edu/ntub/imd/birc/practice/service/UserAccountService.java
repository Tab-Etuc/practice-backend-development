package tw.edu.ntub.imd.birc.practice.service;

import tw.edu.ntub.imd.birc.practice.dto.UserAccountDto;

public interface UserAccountService extends BaseService<UserAccountDto, Integer> {
    UserAccountDto register(UserAccountDto userAccountDto);

    UserAccountDto getUserIdentity(String account);
}
