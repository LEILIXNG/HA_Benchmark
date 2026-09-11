package nw.pricingcapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("pricingcaptureController")
@RequestMapping("/api/pricing")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final RefundCollector refundCollector;

    public ContractController(RefundCollector refundCollector) {
        this.refundCollector = refundCollector;
    }

    @GetMapping("/capture")
    public ResponseEntity<String> resolve(
            @RequestParam("filename") String filename) {
        LOG.debug("接收到一次定价处理请求");
        this.refundCollector.route(filename);
        return ResponseEntity.ok("ok");
    }
}
