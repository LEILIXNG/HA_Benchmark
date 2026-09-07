package com.habench.ordermerge.web;

import com.habench.ordermerge.web.ManifestRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordermergeController")
public class TariffController {

    @GetMapping("/api/order/merge")
    public String route(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        ManifestRouter.compose(label);
        return "ok";
    }
}
