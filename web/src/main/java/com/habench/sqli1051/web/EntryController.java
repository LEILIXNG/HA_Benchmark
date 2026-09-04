package com.habench.sqli1051.web;

import com.habench.sqli1051.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1051EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1051")
    public String handle(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        Stage00.apply(tag);
        return "ok";
    }
}
