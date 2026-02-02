package tw.edu.ntub.imd.birc.practice.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.practice.databaseconfig.Config;

import javax.persistence.*;

@Data
@Entity
@Table(name = "grade", schema = Config.DATABASE_NAME)
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;
}
