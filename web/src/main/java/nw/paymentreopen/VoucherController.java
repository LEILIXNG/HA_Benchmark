package nw.paymentreopen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("paymentreopenController")
public class VoucherController {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherController.class);
    private final BundleRouter bundleRouter;

    public VoucherController(BundleRouter bundleRouter) {
        this.bundleRouter = bundleRouter;
    }

    @GetMapping("/api/payment/reopen")
    public ResponseEntity<String> refine(
            @RequestParam("keyword") String keyword) {
        LOG.debug("支付流程转下一环节");
        this.bundleRouter.stage(keyword);
        return ResponseEntity.ok("done");
    }
}
