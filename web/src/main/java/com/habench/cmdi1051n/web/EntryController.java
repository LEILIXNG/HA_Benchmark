package com.habench.cmdi1051n.web;

import com.habench.cmdi1051n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1051nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1051_n")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Stage00.apply(category);
        return "ok";
    }
}
