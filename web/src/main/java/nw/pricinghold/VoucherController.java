package nw.pricinghold;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("pricingholdController")
public class VoucherController {

    @GetMapping("/api/pricing/hold")
    public String refine(
            @CookieValue("voucher_ref") String label) {
        ChannelCoordinator.register(label);
        return "ok";
    }
}
