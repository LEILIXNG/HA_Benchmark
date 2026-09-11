package nw.paymentgrant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("paymentgrantController")
public class BundleController {

    @GetMapping("/api/payment/grant/{target}")
    public String reconcile(
            @PathVariable("target") String target) {
        ReceiptTranslator.forward(target);
        return "ok";
    }
}
