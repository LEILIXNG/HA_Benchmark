package com.northwind.accountposting.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("accountpostingController")
public class TariffController {
    private final TariffEnricher tariffEnricher;

    public TariffController(TariffEnricher tariffEnricher) {
        this.tariffEnricher = tariffEnricher;
    }

    @GetMapping("/api/account/posting")
    public ResponseEntity<String> collect(
            @RequestParam("label") String label) {
        this.tariffEnricher.resolve(label);
        return ResponseEntity.ok("done");
    }
}
