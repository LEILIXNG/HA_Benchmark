package com.habench.sqli1046n.web;

import com.habench.sqli1046n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1046nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1046_n")
    public String handle(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        Stage00.handle(target);
        return "ok";
    }
}
