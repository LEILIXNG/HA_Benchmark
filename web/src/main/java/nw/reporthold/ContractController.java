package nw.reporthold;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("reportholdController")
@RequestMapping("/api/report")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final BundleRegistry bundleRegistry;

    public ContractController(BundleRegistry bundleRegistry) {
        this.bundleRegistry = bundleRegistry;
    }

    @GetMapping("/hold")
    public ResponseEntity<String> reconcile(
            @RequestParam("reference") String reference) {
        LOG.debug("接收到一次报表处理请求");
        this.bundleRegistry.normalize(reference);
        return ResponseEntity.ok("ok");
    }
}
