package nw.accountverify;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("accountverifyController")
public class BundleController {
    private final BundleRegistry bundleRegistry;

    public BundleController(BundleRegistry bundleRegistry) {
        this.bundleRegistry = bundleRegistry;
    }

    @GetMapping("/api/account/verify")
    public ResponseEntity<String> route(HttpServletRequest request) {
        String filename = request.getHeader("X-Bundle-Context");
        this.bundleRegistry.normalize(filename);
        return ResponseEntity.ok("done");
    }
}
