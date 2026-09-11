package nw.fulfilapprove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向履约场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("fulfilapproveController")
@RequestMapping("/api/fulfil")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final AccountBuilder accountBuilder;

    public BundleController(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    @GetMapping("/approve/{tag}")
    public ResponseEntity<String> assemble(
            @PathVariable("tag") String tag) {
        LOG.trace("进入履约处理环节");
        this.accountBuilder.merge(tag);
        return ResponseEntity.ok("done");
    }
}
