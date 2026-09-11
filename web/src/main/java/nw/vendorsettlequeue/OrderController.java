package nw.vendorsettlequeue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("vendorsettlequeueController")
@RequestMapping("/api/vendor")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final BatchEnricher batchEnricher;

    public OrderController(BatchEnricher batchEnricher) {
        this.batchEnricher = batchEnricher;
    }

    @GetMapping("/settlequeue")
    public String dispatch(
            @RequestParam("tag") String tag) {
        LOG.debug("接收到一次供应商处理请求");
        this.batchEnricher.forward(tag);
        return "ok";
    }
}
