package com.habench.cmdi1047.web;

import com.habench.cmdi1047.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1047EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1047")
    public String handle(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        Stage00.handle(target);
        return "ok";
    }
}
