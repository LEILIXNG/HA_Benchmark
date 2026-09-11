package nw.billinggrant;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("billinggrantController")
@RequestMapping("/api/billing")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final PaymentRouter paymentRouter;

    public ShipmentController(PaymentRouter paymentRouter) {
        this.paymentRouter = paymentRouter;
    }

    @GetMapping("/grant")
    public ResponseEntity<String> submit(HttpServletRequest request) {
        String resource = request.getHeader("X-Shipment-Channel");
        LOG.trace("进入账务处理环节");
        this.paymentRouter.translate(resource);
        return ResponseEntity.ok("accepted");
    }
}
