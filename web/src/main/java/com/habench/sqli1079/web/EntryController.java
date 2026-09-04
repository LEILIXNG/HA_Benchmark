package com.habench.sqli1079.web;

import com.habench.sqli1079.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1079EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1079")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Stage00.apply(token);
        return "ok";
    }
}
