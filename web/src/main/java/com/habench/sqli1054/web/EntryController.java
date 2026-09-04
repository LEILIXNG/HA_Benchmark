package com.habench.sqli1054.web;

import com.habench.sqli1054.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1054EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1054")
    public String handle(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        Stage00.apply(reference);
        return "ok";
    }
}
