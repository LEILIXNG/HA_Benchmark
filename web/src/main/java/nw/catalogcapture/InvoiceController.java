package nw.catalogcapture;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("catalogcaptureController")
@RequestMapping("/api/catalog")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final CatalogBroker catalogBroker;

    public InvoiceController(CatalogBroker catalogBroker) {
        this.catalogBroker = catalogBroker;
    }

    @GetMapping("/capture")
    public String enrich(HttpServletRequest request) {
        String reference = request.getHeader("X-Invoice-Trace");
        LOG.debug("开始整理商品字段");
        this.catalogBroker.stage(reference);
        return "ok";
    }
}
