package nw.catalogledger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("catalogledgerController")
@RequestMapping("/api/catalog")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);
    private final TariffValidator tariffValidator;

    public TariffController(TariffValidator tariffValidator) {
        this.tariffValidator = tariffValidator;
    }

    @GetMapping("/ledger/{keyword}")
    public ResponseEntity<String> collect(
            @PathVariable("keyword") String keyword) {
        LOG.debug("商品流程转下一环节");
        this.tariffValidator.prepare(keyword);
        return ResponseEntity.ok("ok");
    }
}
