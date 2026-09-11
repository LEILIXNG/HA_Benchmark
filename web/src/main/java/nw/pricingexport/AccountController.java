package nw.pricingexport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("pricingexportController")
@RequestMapping("/api/pricing")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final InvoiceBroker invoiceBroker;

    public AccountController(InvoiceBroker invoiceBroker) {
        this.invoiceBroker = invoiceBroker;
    }

    @GetMapping("/export")
    public String route(
            @CookieValue("account_ctx") String category) {
        LOG.debug("接收到一次定价处理请求");
        this.invoiceBroker.assemble(category);
        return "accepted";
    }
}
