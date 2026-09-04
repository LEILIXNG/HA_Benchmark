package com.habench.cmdi1055.web;

import com.habench.cmdi1055.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1055EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1055")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Stage00.apply(filename);
        return "ok";
    }
}
