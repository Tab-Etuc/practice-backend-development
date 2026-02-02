package tw.edu.ntub.imd.birc.practice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.practice.dto.PageResult;
import tw.edu.ntub.imd.birc.practice.dto.MemberDto;
import tw.edu.ntub.imd.birc.practice.service.MemberService;

import org.springframework.security.access.prepost.PreAuthorize;
import tw.edu.ntub.imd.birc.practice.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.practice.config.util.SecurityUtils;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberApi {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<String> getMemberList() {
        return ResponseEntityBuilder.success()
                .data(memberService.searchAll())
                .build();
    }

    @GetMapping("/list")
    public ResponseEntity<String> getMemberListWithPagination(
            @RequestParam(name = "nowPage", defaultValue = "0") Integer nowPage,
            @RequestParam(name = "keyWord", required = false) String keyWord) {
        PageResult<MemberDto> result = memberService.search(nowPage, keyWord);
        return ResponseEntityBuilder.success()
                .data(result.getData())
                .build();
    }

    @GetMapping("/list/page")
    public ResponseEntity<String> getTotalPages(
            @RequestParam(name = "keyWord", required = false) String keyWord) {
        PageResult<MemberDto> result = memberService.search(0, keyWord);
        return ResponseEntityBuilder.success()
                .data(Map.of("totalPage", result.getTotalPage()))
                .build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<String> getMember(@PathVariable Integer memberId) {
        return ResponseEntityBuilder.success()
                .data(memberService.getById(memberId).orElse(null))
                .build();
    }

    @PreAuthorize(SecurityUtils.HAS_ANY_ADMIN_AUTHORITY)
    @PostMapping("/create")
    public ResponseEntity<String> addMember(@RequestBody MemberDto memberDto) {
        return ResponseEntityBuilder.success()
                .data(memberService.save(memberDto))
                .build();
    }

    @PreAuthorize(SecurityUtils.HAS_ANY_ADMIN_OR_STUDENT_AUTHORITY)
    @PatchMapping("/update/{memberId}")
    public ResponseEntity<String> updateMember(@PathVariable Integer memberId, @RequestBody MemberDto memberDto) {
        memberService.update(memberId, memberDto);
        return ResponseEntityBuilder.success()
                .data(memberService.getById(memberId).orElse(null))
                .build();
    }

    @PreAuthorize(SecurityUtils.HAS_ANY_ADMIN_OR_STUDENT_AUTHORITY)
    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Integer memberId) {
        memberService.delete(memberId);
        return ResponseEntityBuilder.success().build();
    }
}
