package nw.reportadjust;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向报表场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("reportadjustController")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final InvoiceBuilder invoiceBuilder;

    public ContractController(InvoiceBuilder invoiceBuilder) {
        this.invoiceBuilder = invoiceBuilder;
    }

    @GetMapping("/api/report/adjust")
    public ResponseEntity<String> expand(
            @RequestHeader("X-Contract-Client") String keyword) {
        LOG.trace("进入报表处理环节");
        this.invoiceBuilder.expand(keyword);
        return ResponseEntity.ok("done");
    }
}
