package nw.reportdigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("reportdigestController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final OrderTranslator orderTranslator;

    public ReceiptController(OrderTranslator orderTranslator) {
        this.orderTranslator = orderTranslator;
    }

    @GetMapping("/api/report/digest")
    public String prepare(
            @CookieValue("receipt_session") String resource) {
        LOG.debug("接收到一次报表处理请求");
        this.orderTranslator.expand(resource);
        return "done";
    }
}
