package tw.edu.ntub.imd.birc.practice.util;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.Member;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MemberSpecification {
    public static Specification<Member> search(String keyWord) {
        return (Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(keyWord)) {
                String likePattern = "%" + keyWord + "%";
                Predicate namePredicate = criteriaBuilder.like(root.get("name"), likePattern);
                Predicate gmailPredicate = criteriaBuilder.like(root.get("gmail"), likePattern);
                predicates.add(criteriaBuilder.or(namePredicate, gmailPredicate));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
