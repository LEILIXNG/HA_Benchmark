package nw.billingreopen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billingreopenController")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final ReceiptCoordinator receiptCoordinator;

    public ChannelController(ReceiptCoordinator receiptCoordinator) {
        this.receiptCoordinator = receiptCoordinator;
    }

    @GetMapping("/api/billing/reopen/{category}")
    public ResponseEntity<String> collect(
            @PathVariable("category") String category) {
        LOG.debug("开始整理账务字段");
        this.receiptCoordinator.assemble(category);
        return ResponseEntity.ok("accepted");
    }
}
