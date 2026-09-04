package com.habench.cmdi1061.web;

import com.habench.cmdi1061.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1061EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1061")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Stage00.handle(category);
        return "ok";
    }
}
