package nw.shippingreview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("shippingreviewController")
@RequestMapping("/api/shipping")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);

    @GetMapping("/review")
    public ResponseEntity<String> refine(
            @CookieValue("bundle_ctx") String query) {
        LOG.trace("进入发运处理环节");
        BundleComposer.register(query);
        return ResponseEntity.ok("done");
    }
}
