package com.habench.vendordraft.web;

import com.habench.vendordraft.web.ReceiptRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendordraftController")
public class ManifestController {

    @GetMapping("/api/vendor/draft")
    public String dispatch(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ReceiptRouter.translate(target);
        return "ok";
    }
}
