package com.habench.cases.java_cmdi_1042.web;

import com.habench.cases.java_cmdi_1042.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1042EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1042")
    public String handle(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        Gateway00.apply(tag);
        return "ok";
    }
}
