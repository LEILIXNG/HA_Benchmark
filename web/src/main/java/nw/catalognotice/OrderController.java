package nw.catalognotice;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("catalognoticeController")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final PaymentBuilder paymentBuilder;

    public OrderController(PaymentBuilder paymentBuilder) {
        this.paymentBuilder = paymentBuilder;
    }

    @GetMapping("/api/catalog/notice")
    public ResponseEntity<String> assemble(HttpServletRequest request) {
        String userName = request.getHeader("X-Order-Context");
        LOG.trace("进入商品处理环节");
        this.paymentBuilder.assemble(userName);
        return ResponseEntity.ok("accepted");
    }
}
