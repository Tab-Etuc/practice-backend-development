package tw.edu.ntub.imd.birc.practice.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.practice.databaseconfig.Config;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "useraccount", schema = Config.DATABASE_NAME)
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sno")
    private Integer sno;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "email", length = 254)
    private String email;

    @Column(name = "account", length = 254)
    private String account;

    @Column(name = "password", length = 254)
    private String password;

    @Column(name = "avilable", length = 1)
    private String avilable;

    @Column(name = "createdate")
    private LocalDateTime createDate;

    @Column(name = "modifydate")
    private LocalDateTime modifyDate;

    @Column(name = "identity", length = 1)
    private String identity;

    @Column(name = "google_id", length = 254)
    private String googleId;

    @Column(name = "grade_id")
    private Integer gradeId;
}
