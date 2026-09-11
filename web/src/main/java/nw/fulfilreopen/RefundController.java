package nw.fulfilreopen;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("fulfilreopenController")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);

    @GetMapping("/api/fulfil/reopen")
    public ResponseEntity<String> collect(HttpServletRequest request) {
        String category = request.getHeader("X-Refund-Reference");
        LOG.debug("履约流程转下一环节");
        ManifestCoordinator.merge(category);
        return ResponseEntity.ok("accepted");
    }
}
