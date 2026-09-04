package com.habench.sqli1026.web;

import com.habench.sqli1026.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1026EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1026")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Stage00.apply(category);
        return "ok";
    }
}
