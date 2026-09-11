package nw.shippingreconcile;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("shippingreconcileController")
@RequestMapping("/api/shipping")
public class PaymentController {
    private final ShipmentRouter shipmentRouter;

    public PaymentController(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    @GetMapping("/reconcile")
    public String publish(HttpServletRequest request) {
        String userName = request.getHeader("X-Payment-Client");
        this.shipmentRouter.merge(userName);
        return "done";
    }
}
