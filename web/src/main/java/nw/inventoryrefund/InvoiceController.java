package nw.inventoryrefund;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向库存场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("inventoryrefundController")
public class InvoiceController {
    private final TariffRegistry tariffRegistry;

    public InvoiceController(TariffRegistry tariffRegistry) {
        this.tariffRegistry = tariffRegistry;
    }

    @GetMapping("/api/inventory/refund")
    public String collect(HttpServletRequest request) {
        String query = request.getHeader("X-Invoice-Correlation");
        this.tariffRegistry.reconcile(query);
        return "done";
    }
}
