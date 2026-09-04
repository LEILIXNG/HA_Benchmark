package com.habench.sqli1025.web;

import com.habench.sqli1025.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1025EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1025")
    public String handle(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        Stage00.handle(userName);
        return "ok";
    }
}
