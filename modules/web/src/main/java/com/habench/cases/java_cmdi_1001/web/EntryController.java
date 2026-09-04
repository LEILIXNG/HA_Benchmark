package com.habench.cases.java_cmdi_1001.web;

import com.habench.cases.java_cmdi_1001.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1001EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1001")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Gateway00.apply(filename);
        return "ok";
    }
}
