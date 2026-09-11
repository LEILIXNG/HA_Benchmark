package nw.catalogsettlequeue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("catalogsettlequeueController")
@RequestMapping("/api/catalog")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final OrderService orderService;

    public RefundController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/settlequeue")
    public ResponseEntity<String> submit(
            @CookieValue("refund_trace") String userName) {
        LOG.trace("进入商品处理环节");
        this.orderService.route(userName);
        return ResponseEntity.ok("ok");
    }
}
