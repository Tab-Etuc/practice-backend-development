package tw.edu.ntub.imd.birc.practice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.edu.ntub.imd.birc.practice.dto.PageResult;
import tw.edu.ntub.imd.birc.practice.databaseconfig.dao.MemberDAO;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.Member;
import tw.edu.ntub.imd.birc.practice.dto.MemberDto;
import tw.edu.ntub.imd.birc.practice.service.MemberService;
import tw.edu.ntub.imd.birc.practice.service.transformer.MemberTransformer;
import tw.edu.ntub.imd.birc.practice.util.MemberSpecification;

import java.util.stream.Collectors;

@Service
public class MemberServiceImpl extends BaseServiceImpl<MemberDto, Member, Integer> implements MemberService {
    private final MemberDAO memberDAO;
    private final MemberTransformer transformer;

    public MemberServiceImpl(MemberDAO memberDAO, MemberTransformer transformer) {
        super(memberDAO, transformer);
        this.memberDAO = memberDAO;
        this.transformer = transformer;
    }

    @Override
    public PageResult<MemberDto> search(Integer page, String keyWord) {
        PageRequest pageRequest = PageRequest.of(page, 10); // Assuming page size is 10
        Page<Member> memberPage = memberDAO.findAll(MemberSpecification.search(keyWord), pageRequest);
        return PageResult.of(
                memberPage.get().map(transformer::transferToBean).collect(Collectors.toList()),
                memberPage.getTotalElements(),
                memberPage.getTotalPages());
    }
}
