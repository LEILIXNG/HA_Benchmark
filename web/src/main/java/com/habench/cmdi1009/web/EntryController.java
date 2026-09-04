package com.habench.cmdi1009.web;

import com.habench.cmdi1009.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1009EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1009")
    public String handle(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        Stage00.apply(label);
        return "ok";
    }
}
