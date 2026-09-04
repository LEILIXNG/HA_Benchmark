package com.habench.cmdi1050n.web;

import com.habench.cmdi1050n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1050nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1050_n")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Stage00.handle(token);
        return "ok";
    }
}
