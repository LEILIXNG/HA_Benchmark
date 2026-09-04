package com.habench.sqli1056.web;

import com.habench.sqli1056.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1056EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1056")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Stage00.handle(token);
        return "ok";
    }
}
