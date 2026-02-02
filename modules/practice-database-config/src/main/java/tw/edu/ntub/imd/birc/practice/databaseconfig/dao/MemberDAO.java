package tw.edu.ntub.imd.birc.practice.databaseconfig.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.Member;

@Repository
public interface MemberDAO extends BaseDAO<Member, Integer>, JpaSpecificationExecutor<Member> {
}
