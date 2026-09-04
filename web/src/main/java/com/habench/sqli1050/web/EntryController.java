package com.habench.sqli1050.web;

import com.habench.sqli1050.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1050EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1050")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Stage00.handle(category);
        return "ok";
    }
}
