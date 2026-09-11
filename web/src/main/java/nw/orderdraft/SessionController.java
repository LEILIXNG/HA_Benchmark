package nw.orderdraft;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向订单场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("orderdraftController")
@RequestMapping("/api/order")
public class SessionController {
    private final ManifestAdapter manifestAdapter;

    public SessionController(ManifestAdapter manifestAdapter) {
        this.manifestAdapter = manifestAdapter;
    }

    @GetMapping("/draft")
    public ResponseEntity<String> stage(HttpServletRequest request) {
        String label = request.getHeader("X-Session-Channel");
        this.manifestAdapter.refine(label);
        return ResponseEntity.ok("done");
    }
}
