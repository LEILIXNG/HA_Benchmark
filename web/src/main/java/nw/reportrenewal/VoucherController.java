package nw.reportrenewal;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("reportrenewalController")
@RequestMapping("/api/report")
public class VoucherController {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherController.class);
    private final TariffEnricher tariffEnricher;

    public VoucherController(TariffEnricher tariffEnricher) {
        this.tariffEnricher = tariffEnricher;
    }

    @GetMapping("/renewal")
    public ResponseEntity<String> translate(HttpServletRequest request) {
        String query = request.getHeader("X-Voucher-Trace");
        LOG.debug("开始整理报表字段");
        this.tariffEnricher.forward(query);
        return ResponseEntity.ok("accepted");
    }
}
