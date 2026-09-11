package nw.billingrenewal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("billingrenewalController")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final RefundRegistry refundRegistry;

    public InvoiceController(RefundRegistry refundRegistry) {
        this.refundRegistry = refundRegistry;
    }

    @GetMapping("/api/billing/renewal")
    public String submit(
            @RequestParam("q") String q) {
        LOG.debug("账务流程转下一环节");
        this.refundRegistry.collect(q);
        return "accepted";
    }
}
