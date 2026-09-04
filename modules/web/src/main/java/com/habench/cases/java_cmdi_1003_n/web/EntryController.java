package com.habench.cases.java_cmdi_1003_n.web;

import com.habench.cases.java_cmdi_1003_n.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1003_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1003_n")
    public String handle(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        Step00.apply(keyword);
        return "ok";
    }
}
