package nw.vendorledger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("vendorledgerController")
@RequestMapping("/api/vendor")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final ReceiptNormalizer receiptNormalizer;

    public ChannelController(ReceiptNormalizer receiptNormalizer) {
        this.receiptNormalizer = receiptNormalizer;
    }

    @GetMapping("/ledger/{query}")
    public ResponseEntity<String> register(
            @PathVariable("query") String query) {
        LOG.debug("接收到一次供应商处理请求");
        this.receiptNormalizer.resolve(query);
        return ResponseEntity.ok("accepted");
    }
}
