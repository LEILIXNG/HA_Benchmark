package nw.customerexport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("customerexportController")
public class ManifestController {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestController.class);
    private final BundleCoordinator bundleCoordinator;

    public ManifestController(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    @GetMapping("/api/customer/export")
    public ResponseEntity<String> enrich(
            @RequestParam("label") String label) {
        LOG.debug("客户流程转下一环节");
        this.bundleCoordinator.reconcile(label);
        return ResponseEntity.ok("accepted");
    }
}
