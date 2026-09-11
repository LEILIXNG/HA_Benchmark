package nw.paymentsplit;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("paymentsplitController")
@RequestMapping("/api/payment")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final VoucherBuilder voucherBuilder;

    public RefundController(VoucherBuilder voucherBuilder) {
        this.voucherBuilder = voucherBuilder;
    }

    @GetMapping("/split")
    public String enrich(HttpServletRequest request) {
        String token = request.getHeader("X-Refund-Context");
        LOG.trace("进入支付处理环节");
        this.voucherBuilder.attach(token);
        return "done";
    }
}
