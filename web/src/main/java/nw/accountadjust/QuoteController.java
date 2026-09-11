package nw.accountadjust;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("accountadjustController")
@RequestMapping("/api/account")
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);
    private final LedgerTranslator ledgerTranslator;

    public QuoteController(LedgerTranslator ledgerTranslator) {
        this.ledgerTranslator = ledgerTranslator;
    }

    @GetMapping("/adjust")
    public ResponseEntity<String> refine(
            @RequestHeader("X-Quote-Reference") String token) {
        LOG.debug("账户流程转下一环节");
        this.ledgerTranslator.merge(token);
        return ResponseEntity.ok("accepted");
    }
}
