package nw.vendorassign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("vendorassignController")
@RequestMapping("/api/vendor")
public class ManifestController {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestController.class);
    private final InvoiceCollector invoiceCollector;

    public ManifestController(InvoiceCollector invoiceCollector) {
        this.invoiceCollector = invoiceCollector;
    }

    @GetMapping("/assign")
    public String publish(
            @CookieValue("manifest_token") String filename) {
        LOG.debug("接收到一次供应商处理请求");
        this.invoiceCollector.register(filename);
        return "accepted";
    }
}
