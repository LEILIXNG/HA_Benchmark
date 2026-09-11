package nw.shippingexport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("shippingexportController")
@RequestMapping("/api/shipping")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);

    @GetMapping("/export")
    public ResponseEntity<String> submit(
            @RequestParam("token") String token) {
        LOG.trace("进入发运处理环节");
        BundleTranslator.expand(token);
        return ResponseEntity.ok("accepted");
    }
}
