package com.habench.cases.java_cmdi_1054.web;

import com.habench.cases.java_cmdi_1054.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1054EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1054")
    public String handle(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        Gateway00.apply(target);
        return "ok";
    }
}
