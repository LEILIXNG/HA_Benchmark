package com.habench.sqli1072.web;

import com.habench.sqli1072.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1072EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1072")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Stage00.handle(resource);
        return "ok";
    }
}
