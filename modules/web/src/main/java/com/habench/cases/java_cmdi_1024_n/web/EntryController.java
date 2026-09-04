package com.habench.cases.java_cmdi_1024_n.web;

import com.habench.cases.java_cmdi_1024_n.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1024_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1024_n")
    public String handle(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        Step00.apply(reference);
        return "ok";
    }
}
