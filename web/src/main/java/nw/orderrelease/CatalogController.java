package nw.orderrelease;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("orderreleaseController")
public class CatalogController {
    private final OrderComposer orderComposer;

    public CatalogController(OrderComposer orderComposer) {
        this.orderComposer = orderComposer;
    }

    @GetMapping("/api/order/release")
    public String reconcile(
            @RequestParam("resource") String resource) {
        this.orderComposer.attach(resource);
        return "done";
    }
}
