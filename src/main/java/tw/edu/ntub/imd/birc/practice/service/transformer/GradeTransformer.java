package tw.edu.ntub.imd.birc.practice.service.transformer;

import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.Grade;
import tw.edu.ntub.imd.birc.practice.dto.GradeDto;

@Component
public class GradeTransformer implements BeanEntityTransformer<GradeDto, Grade> {
    @Override
    public Grade transferToEntity(GradeDto gradeDto) {
        Grade grade = new Grade();
        grade.setId(gradeDto.getId());
        grade.setName(gradeDto.getName());
        return grade;
    }

    @Override
    public GradeDto transferToBean(Grade grade) {
        GradeDto gradeDto = new GradeDto();
        gradeDto.setId(grade.getId());
        gradeDto.setName(grade.getName());
        return gradeDto;
    }
}
