package nw.orderbind;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("orderbindController")
@RequestMapping("/api/order")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);
    private final ChannelNormalizer channelNormalizer;

    public BatchController(ChannelNormalizer channelNormalizer) {
        this.channelNormalizer = channelNormalizer;
    }

    @GetMapping("/bind")
    public String translate(HttpServletRequest request) {
        String target = request.getHeader("X-Batch-Correlation");
        LOG.debug("开始整理订单字段");
        this.channelNormalizer.merge(target);
        return "accepted";
    }
}
