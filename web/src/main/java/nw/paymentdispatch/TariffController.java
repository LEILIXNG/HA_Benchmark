package nw.paymentdispatch;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("paymentdispatchController")
@RequestMapping("/api/payment")
public class TariffController {
    private final VoucherTranslator voucherTranslator;

    public TariffController(VoucherTranslator voucherTranslator) {
        this.voucherTranslator = voucherTranslator;
    }

    @GetMapping("/dispatch")
    public String refine(
            @CookieValue("tariff_trace") String orderNo) {
        this.voucherTranslator.forward(orderNo);
        return "ok";
    }
}
