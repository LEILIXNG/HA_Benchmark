package nw.vendordigest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("vendordigestController")
@RequestMapping("/api/vendor")
public class TariffController {
    private final SessionRegistry sessionRegistry;

    public TariffController(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @GetMapping("/digest/{filename}")
    public ResponseEntity<String> publish(
            @PathVariable("filename") String filename) {
        this.sessionRegistry.translate(filename);
        return ResponseEntity.ok("done");
    }
}
