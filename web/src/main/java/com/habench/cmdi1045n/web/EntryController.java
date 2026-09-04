package com.habench.cmdi1045n.web;

import com.habench.cmdi1045n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1045nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1045_n")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Stage00.apply(filename);
        return "ok";
    }
}
