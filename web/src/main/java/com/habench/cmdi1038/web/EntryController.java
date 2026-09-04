package com.habench.cmdi1038.web;

import com.habench.cmdi1038.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1038EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1038")
    public String handle(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        Stage00.handle(orderNo);
        return "ok";
    }
}
