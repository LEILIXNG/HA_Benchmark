package com.habench.customergrant.web;

import com.habench.customergrant.web.QuoteRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customergrantController")
public class TariffController {

    @GetMapping("/api/customer/grant/{filename}")
    public String collect(
            @PathVariable("filename") String filename) {
        QuoteRouter.compose(filename);
        return "ok";
    }
}
