package com.habench.cmdi1044n.web;

import com.habench.cmdi1044n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1044nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1044_n")
    public String handle(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        Stage00.apply(target);
        return "ok";
    }
}
