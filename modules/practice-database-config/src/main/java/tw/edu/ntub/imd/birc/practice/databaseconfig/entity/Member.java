package tw.edu.ntub.imd.birc.practice.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.practice.databaseconfig.Config;

import javax.persistence.*;

@Data
@Entity
@Table(name = "members", schema = Config.DATABASE_NAME)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "gmail", length = 100)
    private String gmail;

    @Column(name = "gender", length = 45)
    private String gender;

    @Column(name = "grade_id")
    private Integer gradeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id", insertable = false, updatable = false)
    private Grade grade;
}
