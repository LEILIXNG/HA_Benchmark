package nw.billingsplit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billingsplitController")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final BatchBuilder batchBuilder;

    public ChannelController(BatchBuilder batchBuilder) {
        this.batchBuilder = batchBuilder;
    }

    @GetMapping("/api/billing/split")
    public ResponseEntity<String> prepare(
            @RequestHeader("X-Channel-Channel") String userName) {
        LOG.debug("开始整理账务字段");
        this.batchBuilder.normalize(userName);
        return ResponseEntity.ok("accepted");
    }
}
