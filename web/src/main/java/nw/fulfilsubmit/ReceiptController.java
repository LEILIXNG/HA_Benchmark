package nw.fulfilsubmit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向履约场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("fulfilsubmitController")
public class ReceiptController {
    private final ShipmentFacade shipmentFacade;

    public ReceiptController(ShipmentFacade shipmentFacade) {
        this.shipmentFacade = shipmentFacade;
    }

    @GetMapping("/api/fulfil/submit/{label}")
    public ResponseEntity<String> forward(
            @PathVariable("label") String label) {
        this.shipmentFacade.attach(label);
        return ResponseEntity.ok("ok");
    }
}
