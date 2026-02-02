package tw.edu.ntub.imd.birc.practice.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.practice.databaseconfig.dao.GradeDAO;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.Grade;
import tw.edu.ntub.imd.birc.practice.dto.GradeDto;
import tw.edu.ntub.imd.birc.practice.service.GradeService;
import tw.edu.ntub.imd.birc.practice.service.transformer.GradeTransformer;

@Service
public class GradeServiceImpl extends BaseServiceImpl<GradeDto, Grade, Integer> implements GradeService {
    public GradeServiceImpl(GradeDAO gradeDAO, GradeTransformer transformer) {
        super(gradeDAO, transformer);
    }
}
