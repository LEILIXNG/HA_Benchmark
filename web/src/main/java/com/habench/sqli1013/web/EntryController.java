package com.habench.sqli1013.web;

import com.habench.sqli1013.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1013EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1013")
    public String handle(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        Stage00.apply(orderNo);
        return "ok";
    }
}
