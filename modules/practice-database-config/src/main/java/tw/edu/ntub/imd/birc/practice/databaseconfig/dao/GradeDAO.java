package tw.edu.ntub.imd.birc.practice.databaseconfig.dao;

import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.Grade;

@Repository
public interface GradeDAO extends BaseDAO<Grade, Integer> {
}
