package nw.paymentreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("paymentreconcileController")
public class ManifestController {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestController.class);
    private final ShipmentCollector shipmentCollector;

    public ManifestController(ShipmentCollector shipmentCollector) {
        this.shipmentCollector = shipmentCollector;
    }

    @GetMapping("/api/payment/reconcile/{filename}")
    public ResponseEntity<String> submit(
            @PathVariable("filename") String filename) {
        LOG.debug("支付流程转下一环节");
        this.shipmentCollector.register(filename);
        return ResponseEntity.ok("ok");
    }
}
