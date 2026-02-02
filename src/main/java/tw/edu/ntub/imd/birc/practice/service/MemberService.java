package tw.edu.ntub.imd.birc.practice.service;

import tw.edu.ntub.imd.birc.practice.dto.PageResult;
import tw.edu.ntub.imd.birc.practice.dto.MemberDto;

public interface MemberService extends BaseService<MemberDto, Integer> {
    PageResult<MemberDto> search(Integer page, String keyWord);
}
