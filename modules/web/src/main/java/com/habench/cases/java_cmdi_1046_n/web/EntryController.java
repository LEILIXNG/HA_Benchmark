package com.habench.cases.java_cmdi_1046_n.web;

import com.habench.cases.java_cmdi_1046_n.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1046_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1046_n")
    public String handle(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        Step00.apply(target);
        return "ok";
    }
}
