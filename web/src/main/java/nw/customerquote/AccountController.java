package nw.customerquote;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("customerquoteController")
public class AccountController {
    private final ShipmentResolver shipmentResolver;

    public AccountController(ShipmentResolver shipmentResolver) {
        this.shipmentResolver = shipmentResolver;
    }

    @GetMapping("/api/customer/quote")
    public ResponseEntity<String> merge(HttpServletRequest request) {
        String resource = request.getHeader("X-Account-Context");
        this.shipmentResolver.stage(resource);
        return ResponseEntity.ok("ok");
    }
}
