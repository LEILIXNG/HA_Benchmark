package nw.pricingtrace;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("pricingtraceController")
public class TariffController {
    private final InvoiceBroker invoiceBroker;

    public TariffController(InvoiceBroker invoiceBroker) {
        this.invoiceBroker = invoiceBroker;
    }

    @GetMapping("/api/pricing/trace/{query}")
    public ResponseEntity<String> resolve(
            @PathVariable("query") String query) {
        this.invoiceBroker.resolve(query);
        return ResponseEntity.ok("accepted");
    }
}
