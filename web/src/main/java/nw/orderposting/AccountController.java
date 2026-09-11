package nw.orderposting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向订单场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("orderpostingController")
@RequestMapping("/api/order")
public class AccountController {
    private final ReceiptRouter receiptRouter;

    public AccountController(ReceiptRouter receiptRouter) {
        this.receiptRouter = receiptRouter;
    }

    @GetMapping("/posting")
    public String route(
            @RequestHeader("X-Account-Reference") String userName) {
        this.receiptRouter.prepare(userName);
        return "done";
    }
}
