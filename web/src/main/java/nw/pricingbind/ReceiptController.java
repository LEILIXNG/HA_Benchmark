package nw.pricingbind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("pricingbindController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final BundleTranslator bundleTranslator;

    public ReceiptController(BundleTranslator bundleTranslator) {
        this.bundleTranslator = bundleTranslator;
    }

    @GetMapping("/api/pricing/bind/{filename}")
    public String stage(
            @PathVariable("filename") String filename) {
        LOG.debug("定价流程转下一环节");
        this.bundleTranslator.expand(filename);
        return "accepted";
    }
}
