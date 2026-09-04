package com.habench.sqli1072n.web;

import com.habench.sqli1072n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1072nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1072_n")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Stage00.handle(resource);
        return "ok";
    }
}
