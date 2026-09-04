package com.habench.cases.java_sqli_1036.web;

import com.habench.cases.java_sqli_1036.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1036EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1036")
    public String handle(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        Gateway00.apply(userName);
        return "ok";
    }
}
