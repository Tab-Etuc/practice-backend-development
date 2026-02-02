package tw.edu.ntub.imd.birc.practice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.practice.dto.UserAccountDto;
import tw.edu.ntub.imd.birc.practice.service.UserAccountService;
import tw.edu.ntub.imd.birc.practice.util.http.ResponseEntityBuilder;

@AllArgsConstructor
@RestController
public class AuthApi {
    private final UserAccountService userAccountService;

    @PostMapping("/user/register")
    public ResponseEntity<String> register(@RequestBody UserAccountDto userAccountDto) {
        userAccountService.register(userAccountDto);
        return ResponseEntityBuilder.success()
                .message("註冊成功")
                .build();
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUserIdentity() {
        String account = SecurityContextHolder.getContext().getAuthentication().getName();
        UserAccountDto userAccountDto = userAccountService.getUserIdentity(account);
        return ResponseEntityBuilder.success()
                .data(userAccountDto)
                .build();
    }
}
