package nw.billingarchive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingarchiveController")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final SessionGuard sessionGuard;

    public ShipmentController(SessionGuard sessionGuard) {
        this.sessionGuard = sessionGuard;
    }

    @GetMapping("/api/billing/archive")
    public String refine(
            @RequestParam("file") String file) {
        LOG.trace("进入账务处理环节");
        this.sessionGuard.enrich(file);
        return "accepted";
    }
}
