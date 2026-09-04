package com.habench.cases.java_cmdi_1014.web;

import com.habench.cases.java_cmdi_1014.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1014EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1014")
    public String handle(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        Step00.apply(reference);
        return "ok";
    }
}
