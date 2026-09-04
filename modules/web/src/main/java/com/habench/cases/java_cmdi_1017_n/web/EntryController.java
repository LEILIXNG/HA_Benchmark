package com.habench.cases.java_cmdi_1017_n.web;

import com.habench.cases.java_cmdi_1017_n.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1017_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1017_n")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Step00.apply(resource);
        return "ok";
    }
}
