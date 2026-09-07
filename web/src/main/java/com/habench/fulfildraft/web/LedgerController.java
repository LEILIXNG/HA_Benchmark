package com.habench.fulfildraft.web;

import com.habench.fulfildraft.web.PaymentRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfildraftController")
public class LedgerController {

    @GetMapping("/api/fulfil/draft/{resource}")
    public String submit(
            @PathVariable("resource") String resource) {
        PaymentRouter.collect(resource);
        return "ok";
    }
}
