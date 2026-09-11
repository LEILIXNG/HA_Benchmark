package nw.reportverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("reportverifyController")
@RequestMapping("/api/report")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final ManifestTranslator manifestTranslator;

    public AccountController(ManifestTranslator manifestTranslator) {
        this.manifestTranslator = manifestTranslator;
    }

    @GetMapping("/verify")
    public ResponseEntity<String> enrich(
            @RequestHeader("X-Account-Origin") String tag) {
        LOG.debug("开始整理报表字段");
        this.manifestTranslator.reconcile(tag);
        return ResponseEntity.ok("done");
    }
}
