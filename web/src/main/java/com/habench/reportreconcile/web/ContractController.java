package com.habench.reportreconcile.web;

import com.habench.reportreconcile.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportreconcileController")
public class ContractController {

    @GetMapping("/api/report/reconcile")
    public String refine(
            @RequestParam("tag") String tag) {
        ManifestNormalizer.assemble(tag);
        return "ok";
    }
}
