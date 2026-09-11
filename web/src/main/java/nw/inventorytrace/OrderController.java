package nw.inventorytrace;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向库存场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("inventorytraceController")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final BatchCoordinator batchCoordinator;

    public OrderController(BatchCoordinator batchCoordinator) {
        this.batchCoordinator = batchCoordinator;
    }

    @GetMapping("/api/inventory/trace")
    public ResponseEntity<String> collect(HttpServletRequest request) {
        String target = request.getHeader("X-Order-Correlation");
        LOG.debug("接收到一次库存处理请求");
        this.batchCoordinator.attach(target);
        return ResponseEntity.ok("done");
    }
}
