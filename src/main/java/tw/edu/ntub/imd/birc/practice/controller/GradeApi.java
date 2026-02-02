package tw.edu.ntub.imd.birc.practice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ntub.imd.birc.practice.dto.GradeDto;
import tw.edu.ntub.imd.birc.practice.service.GradeService;
import tw.edu.ntub.imd.birc.practice.util.http.ResponseEntityBuilder;

@AllArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeApi {
    private final GradeService gradeService;

    @GetMapping("/")
    public ResponseEntity<String> getGradeList() {
        return ResponseEntityBuilder.success()
                .data(gradeService.searchAll())
                .build();
    }
}
