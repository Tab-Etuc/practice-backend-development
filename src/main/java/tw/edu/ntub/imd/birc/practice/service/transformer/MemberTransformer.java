package tw.edu.ntub.imd.birc.practice.service.transformer;

import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.Grade;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.Member;

import tw.edu.ntub.imd.birc.practice.dto.MemberDto;

@Component
public class MemberTransformer implements BeanEntityTransformer<MemberDto, Member> {
    private final GradeTransformer gradeTransformer;

    public MemberTransformer(GradeTransformer gradeTransformer) {
        this.gradeTransformer = gradeTransformer;
    }

    @Override
    public Member transferToEntity(MemberDto memberDto) {
        Member member = JavaBeanUtils.copy(memberDto, new Member());
        if (memberDto.getGrade() != null) {
            member.setGrade(gradeTransformer.transferToEntity(memberDto.getGrade()));
        }
        return member;
    }

    @Override
    public void updateEntity(MemberDto memberDto, Member member) {
        JavaBeanUtils.copy(memberDto, member);
        if (memberDto.getGrade() != null) {
            member.setGrade(gradeTransformer.transferToEntity(memberDto.getGrade()));
        }
    }

    @Override
    public MemberDto transferToBean(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setName(member.getName());
        memberDto.setAccount("");
        memberDto.setGmail(member.getGmail());
        memberDto.setGradeId(member.getGradeId());
        memberDto.setGender(member.getGender());

        if (member.getGrade() != null) {
            memberDto.setGrade(gradeTransformer.transferToBean(member.getGrade()));
        }
        return memberDto;
    }
}
