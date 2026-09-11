package nw.shippingrenewal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("shippingrenewalController")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);

    @GetMapping("/api/shipping/renewal")
    public String reconcile(
            @CookieValue("refund_session") String keyword) {
        LOG.debug("开始整理发运字段");
        InvoiceBroker.reconcile(keyword);
        return "ok";
    }
}
