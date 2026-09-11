package nw.shippingdispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("shippingdispatchController")
@RequestMapping("/api/shipping")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final InvoiceBuilder invoiceBuilder;

    public BundleController(InvoiceBuilder invoiceBuilder) {
        this.invoiceBuilder = invoiceBuilder;
    }

    @GetMapping("/dispatch")
    public String publish(
            @RequestParam("orderNo") String orderNo) {
        LOG.trace("进入发运处理环节");
        this.invoiceBuilder.publish(orderNo);
        return "done";
    }
}
