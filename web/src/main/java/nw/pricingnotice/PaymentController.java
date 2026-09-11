package nw.pricingnotice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("pricingnoticeController")
@RequestMapping("/api/pricing")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    private final BundleBuilder bundleBuilder;

    public PaymentController(BundleBuilder bundleBuilder) {
        this.bundleBuilder = bundleBuilder;
    }

    @GetMapping("/notice")
    public String resolve(
            @RequestHeader("X-Payment-Context") String tag) {
        LOG.trace("进入定价处理环节");
        this.bundleBuilder.publish(tag);
        return "accepted";
    }
}
