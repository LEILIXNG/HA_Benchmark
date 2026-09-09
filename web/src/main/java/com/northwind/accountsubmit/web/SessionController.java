package com.northwind.accountsubmit.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("accountsubmitController")
public class SessionController {
    private final ManifestEnricher manifestEnricher;

    public SessionController(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    @GetMapping("/api/account/submit")
    public ResponseEntity<String> dispatch(
            @CookieValue("session_trace") String resource) {
        this.manifestEnricher.translate(resource);
        return ResponseEntity.ok("accepted");
    }
}
