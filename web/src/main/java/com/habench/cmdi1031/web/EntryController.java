package com.habench.cmdi1031.web;

import com.habench.cmdi1031.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1031EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1031")
    public String handle(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        Stage00.apply(query);
        return "ok";
    }
}
