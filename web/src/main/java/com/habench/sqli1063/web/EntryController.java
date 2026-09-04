package com.habench.sqli1063.web;

import com.habench.sqli1063.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1063EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1063")
    public String handle(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        Stage00.handle(reference);
        return "ok";
    }
}
