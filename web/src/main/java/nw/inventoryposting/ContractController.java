package nw.inventoryposting;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("inventorypostingController")
@RequestMapping("/api/inventory")
public class ContractController {
    private final OrderResolver orderResolver;

    public ContractController(OrderResolver orderResolver) {
        this.orderResolver = orderResolver;
    }

    @GetMapping("/posting/{target}")
    public ResponseEntity<String> forward(
            @PathVariable("target") String target) {
        this.orderResolver.translate(target);
        return ResponseEntity.ok("accepted");
    }
}
