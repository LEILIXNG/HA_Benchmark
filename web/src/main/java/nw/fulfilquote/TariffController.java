package nw.fulfilquote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("fulfilquoteController")
public class TariffController {
    private final RefundService refundService;

    public TariffController(RefundService refundService) {
        this.refundService = refundService;
    }

    @GetMapping("/api/fulfil/quote")
    public String attach(
            @RequestParam("orderNo") String orderNo) {
        this.refundService.attach(orderNo);
        return "accepted";
    }
}
