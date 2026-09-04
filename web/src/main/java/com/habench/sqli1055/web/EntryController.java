package com.habench.sqli1055.web;

import com.habench.sqli1055.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1055EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1055")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Stage00.handle(filename);
        return "ok";
    }
}
