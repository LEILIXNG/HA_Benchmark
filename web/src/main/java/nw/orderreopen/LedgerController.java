package nw.orderreopen;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("orderreopenController")
public class LedgerController {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerController.class);

    @GetMapping("/api/order/reopen")
    public ResponseEntity<String> publish(HttpServletRequest request) {
        String query = request.getHeader("X-Ledger-Correlation");
        LOG.debug("开始整理订单字段");
        SessionResolver.collect(query);
        return ResponseEntity.ok("accepted");
    }
}
