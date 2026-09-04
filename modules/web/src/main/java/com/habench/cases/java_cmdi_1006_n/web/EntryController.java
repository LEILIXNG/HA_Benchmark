package com.habench.cases.java_cmdi_1006_n.web;

import com.habench.cases.java_cmdi_1006_n.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1006_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1006_n")
    public String handle(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        Gateway00.apply(label);
        return "ok";
    }
}
