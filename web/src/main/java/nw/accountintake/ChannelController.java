package nw.accountintake;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("accountintakeController")
@RequestMapping("/api/account")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final BatchEnricher batchEnricher;

    public ChannelController(BatchEnricher batchEnricher) {
        this.batchEnricher = batchEnricher;
    }

    @GetMapping("/intake")
    public String register(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Channel-Channel");
        LOG.debug("开始整理账户字段");
        this.batchEnricher.compose(orderNo);
        return "done";
    }
}
