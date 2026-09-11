package nw.pricingreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("pricingreconcileController")
public class VoucherController {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherController.class);

    @GetMapping("/api/pricing/reconcile")
    public String publish(
            @RequestParam("filename") String filename) {
        LOG.debug("定价流程转下一环节");
        AccountNormalizer.attach(filename);
        return "accepted";
    }
}
