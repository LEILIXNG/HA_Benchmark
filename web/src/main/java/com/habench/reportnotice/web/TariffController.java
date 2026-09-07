package com.habench.reportnotice.web;

import com.habench.reportnotice.web.SessionTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportnoticeController")
public class TariffController {

    @GetMapping("/api/report/notice")
    public String refine(
            @RequestParam("label") String label) {
        SessionTranslator.assemble(label);
        return "ok";
    }
}
