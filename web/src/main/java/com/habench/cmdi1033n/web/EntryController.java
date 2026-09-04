package com.habench.cmdi1033n.web;

import com.habench.cmdi1033n.web.Sanitizer00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1033nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1033_n")
    public String handle(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        Sanitizer00.apply(keyword);
        return "ok";
    }
}
