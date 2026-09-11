package nw.catalogdraft;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向商品场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("catalogdraftController")
@RequestMapping("/api/catalog")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    private final VoucherBuilder voucherBuilder;

    public PaymentController(VoucherBuilder voucherBuilder) {
        this.voucherBuilder = voucherBuilder;
    }

    @GetMapping("/draft")
    public ResponseEntity<String> submit(HttpServletRequest request) {
        String category = request.getHeader("X-Payment-Context");
        LOG.debug("商品流程转下一环节");
        this.voucherBuilder.assemble(category);
        return ResponseEntity.ok("done");
    }
}
