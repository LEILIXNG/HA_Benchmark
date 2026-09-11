package nw.shippingquote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("shippingquoteController")
@RequestMapping("/api/shipping")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final LedgerBuilder ledgerBuilder;

    public AccountController(LedgerBuilder ledgerBuilder) {
        this.ledgerBuilder = ledgerBuilder;
    }

    @GetMapping("/quote")
    public ResponseEntity<String> reconcile(
            @CookieValue("account_session") String resource) {
        LOG.debug("发运流程转下一环节");
        this.ledgerBuilder.normalize(resource);
        return ResponseEntity.ok("ok");
    }
}
