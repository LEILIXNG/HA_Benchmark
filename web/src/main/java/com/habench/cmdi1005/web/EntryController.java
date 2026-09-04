package com.habench.cmdi1005.web;

import com.habench.cmdi1005.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1005EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1005")
    public String handle(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        Stage00.apply(keyword);
        return "ok";
    }
}
