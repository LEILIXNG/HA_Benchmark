package com.habench.sqli1031.web;

import com.habench.sqli1031.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1031EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1031")
    public String handle(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        Stage00.apply(label);
        return "ok";
    }
}
