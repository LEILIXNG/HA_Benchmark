package com.habench.sqli1041.web;

import com.habench.sqli1041.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1041EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1041")
    public String handle(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        Stage00.apply(orderNo);
        return "ok";
    }
}
