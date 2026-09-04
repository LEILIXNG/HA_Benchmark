package com.habench.sqli1005.web;

import com.habench.sqli1005.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1005EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1005")
    public String handle(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        Stage00.apply(userName);
        return "ok";
    }
}
