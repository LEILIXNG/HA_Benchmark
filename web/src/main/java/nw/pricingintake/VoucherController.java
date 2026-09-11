package nw.pricingintake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向定价场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("pricingintakeController")
@RequestMapping("/api/pricing")
public class VoucherController {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherController.class);

    @GetMapping("/intake")
    public String forward(
            @RequestParam("label") String label) {
        LOG.debug("开始整理定价字段");
        BundleComposer.publish(label);
        return "ok";
    }
}
