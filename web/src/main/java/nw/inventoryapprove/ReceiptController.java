package nw.inventoryapprove;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("inventoryapproveController")
@RequestMapping("/api/inventory")
public class ReceiptController {
    private final ReceiptBroker receiptBroker;

    public ReceiptController(ReceiptBroker receiptBroker) {
        this.receiptBroker = receiptBroker;
    }

    @GetMapping("/approve")
    public String resolve(
            @RequestHeader("X-Receipt-Trace") String category) {
        this.receiptBroker.enrich(category);
        return "done";
    }
}
