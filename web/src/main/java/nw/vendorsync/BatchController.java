package nw.vendorsync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("vendorsyncController")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);
    private final InvoiceResolver invoiceResolver;

    public BatchController(InvoiceResolver invoiceResolver) {
        this.invoiceResolver = invoiceResolver;
    }

    @GetMapping("/api/vendor/sync/{label}")
    public String refine(
            @PathVariable("label") String label) {
        LOG.debug("供应商流程转下一环节");
        this.invoiceResolver.refine(label);
        return "ok";
    }
}
