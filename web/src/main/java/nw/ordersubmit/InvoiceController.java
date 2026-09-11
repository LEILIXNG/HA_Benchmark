package nw.ordersubmit;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("ordersubmitController")
@RequestMapping("/api/order")
public class InvoiceController {
    private final BundleCollector bundleCollector;

    public InvoiceController(BundleCollector bundleCollector) {
        this.bundleCollector = bundleCollector;
    }

    @GetMapping("/submit")
    public String collect(HttpServletRequest request) {
        String category = request.getHeader("X-Invoice-Trace");
        this.bundleCollector.reconcile(category);
        return "done";
    }
}
