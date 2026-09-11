package nw.ordergrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("ordergrantController")
@RequestMapping("/api/order")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final ReceiptNormalizer receiptNormalizer;

    public CatalogController(ReceiptNormalizer receiptNormalizer) {
        this.receiptNormalizer = receiptNormalizer;
    }

    @GetMapping("/grant/{label}")
    public String publish(
            @PathVariable("label") String label) {
        LOG.debug("开始整理订单字段");
        this.receiptNormalizer.compose(label);
        return "accepted";
    }
}
