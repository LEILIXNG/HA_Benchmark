package com.habench.cases.java_cmdi_1053.web;

import com.habench.cases.java_cmdi_1053.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1053EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1053")
    public String handle(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        Gateway00.apply(keyword);
        return "ok";
    }
}
