package nw.inventorydispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("inventorydispatchController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);

    @GetMapping("/api/inventory/dispatch")
    public String normalize(
            @RequestHeader("X-Receipt-Context") String target) {
        LOG.debug("开始整理库存字段");
        InvoiceValidator.register(target);
        return "ok";
    }
}
