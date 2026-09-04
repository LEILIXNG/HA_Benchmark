package com.habench.cmdi1007.web;

import com.habench.cmdi1007.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1007EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1007")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Stage00.apply(token);
        return "ok";
    }
}
