package nw.customerapprove;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("customerapproveController")
public class OrderController {
    private final OrderResolver2 orderResolver2;

    public OrderController(OrderResolver2 orderResolver2) {
        this.orderResolver2 = orderResolver2;
    }

    @GetMapping("/api/customer/approve")
    public ResponseEntity<String> compose(HttpServletRequest request) {
        String userName = request.getHeader("X-Order-Client");
        this.orderResolver2.resolve(userName);
        return ResponseEntity.ok("done");
    }
}
