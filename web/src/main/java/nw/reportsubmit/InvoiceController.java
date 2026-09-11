package nw.reportsubmit;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向报表场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("reportsubmitController")
public class InvoiceController {
    private final OrderCollector orderCollector;

    public InvoiceController(OrderCollector orderCollector) {
        this.orderCollector = orderCollector;
    }

    @GetMapping("/api/report/submit")
    public String resolve(HttpServletRequest request) {
        String category = request.getHeader("X-Invoice-Tenant");
        this.orderCollector.refine(category);
        return "ok";
    }
}
