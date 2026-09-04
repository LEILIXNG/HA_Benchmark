package com.habench.cmdi1051.web;

import com.habench.cmdi1051.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1051EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1051")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Stage00.apply(category);
        return "ok";
    }
}
