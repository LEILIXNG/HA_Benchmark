package nw.inventoryassign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("inventoryassignController")
public class ManifestController {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestController.class);
    private final RefundTranslator refundTranslator;

    public ManifestController(RefundTranslator refundTranslator) {
        this.refundTranslator = refundTranslator;
    }

    @GetMapping("/api/inventory/assign/{target}")
    public String resolve(
            @PathVariable("target") String target) {
        LOG.trace("进入库存处理环节");
        this.refundTranslator.refine(target);
        return "ok";
    }
}
