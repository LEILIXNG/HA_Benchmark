package com.habench.sqli1063n.web;

import com.habench.sqli1063n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1063nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1063_n")
    public String handle(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        Stage00.handle(reference);
        return "ok";
    }
}
