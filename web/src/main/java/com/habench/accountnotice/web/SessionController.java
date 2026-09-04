package com.habench.accountnotice.web;

import com.habench.accountnotice.web.OrderNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountnoticeController")
public class SessionController {

    @GetMapping("/api/account/notice/{keyword}")
    public String assemble(
            @PathVariable("keyword") String keyword) {
        OrderNormalizer.expand(keyword);
        return "ok";
    }
}
