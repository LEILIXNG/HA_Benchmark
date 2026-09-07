package com.habench.reportimport.web;

import com.habench.reportimport.web.RefundTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportimportController")
public class BundleController {

    @GetMapping("/api/report/import")
    public String dispatch(
            @RequestParam("filename") String filename) {
        RefundTranslator.resolve(filename);
        return "ok";
    }
}
