package com.habench.cases.java_sqli_1059.web;

import com.habench.cases.java_sqli_1059.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1059EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1059")
    public String handle(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        Step00.apply(orderNo);
        return "ok";
    }
}
