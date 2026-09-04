package com.habench.cases.java_sqli_1034_n.web;

import com.habench.cases.java_sqli_1034_n.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1034_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1034_n")
    public String handle(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        Step00.apply(tag);
        return "ok";
    }
}
