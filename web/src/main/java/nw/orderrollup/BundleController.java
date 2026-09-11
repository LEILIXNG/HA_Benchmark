package nw.orderrollup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("orderrollupController")
public class BundleController {
    private final VoucherCollector voucherCollector;

    public BundleController(VoucherCollector voucherCollector) {
        this.voucherCollector = voucherCollector;
    }

    @GetMapping("/api/order/rollup/{keyword}")
    public String publish(
            @PathVariable("keyword") String keyword) {
        this.voucherCollector.merge(keyword);
        return "ok";
    }
}
