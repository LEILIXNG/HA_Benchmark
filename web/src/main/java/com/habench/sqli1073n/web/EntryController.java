package com.habench.sqli1073n.web;

import com.habench.sqli1073n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1073nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1073_n")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Stage00.handle(token);
        return "ok";
    }
}
