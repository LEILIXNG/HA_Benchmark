package nw.orderexport;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("orderexportController")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final ContractBuilder contractBuilder;

    public BundleController(ContractBuilder contractBuilder) {
        this.contractBuilder = contractBuilder;
    }

    @GetMapping("/api/order/export")
    public String prepare(HttpServletRequest request) {
        String resource = request.getHeader("X-Bundle-Trace");
        LOG.debug("订单流程转下一环节");
        this.contractBuilder.submit(resource);
        return "done";
    }
}
