package tw.edu.ntub.imd.birc.practice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MemberDto {
    @JsonProperty("memberId")
    private Integer id;
    private String name;
    private String account;
    private String gmail;
    private String gender;
    private Integer gradeId;
    private GradeDto grade;

    public String getGradeName() {
        return grade != null ? grade.getName() : null;
    }

    public void setGender(String gender) {
        if ("0".equals(gender)) {
            this.gender = "男";
        } else if ("1".equals(gender)) {
            this.gender = "女";
        } else {
            this.gender = gender;
        }
    }
}
