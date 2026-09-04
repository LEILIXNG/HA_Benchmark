package com.habench.cases.java_sqli_1048.web;

import com.habench.cases.java_sqli_1048.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1048EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1048")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Gateway00.apply(category);
        return "ok";
    }
}
