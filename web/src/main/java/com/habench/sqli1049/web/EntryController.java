package com.habench.sqli1049.web;

import com.habench.sqli1049.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1049EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1049")
    public String handle(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        Stage00.handle(orderNo);
        return "ok";
    }
}
