package nw.fulfilbind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("fulfilbindController")
@RequestMapping("/api/fulfil")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final RefundComposer refundComposer;

    public CatalogController(RefundComposer refundComposer) {
        this.refundComposer = refundComposer;
    }

    @GetMapping("/bind/{orderNo}")
    public ResponseEntity<String> stage(
            @PathVariable("orderNo") String orderNo) {
        LOG.debug("接收到一次履约处理请求");
        this.refundComposer.prepare(orderNo);
        return ResponseEntity.ok("ok");
    }
}
