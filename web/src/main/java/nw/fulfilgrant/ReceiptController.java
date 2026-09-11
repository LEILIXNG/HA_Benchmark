package nw.fulfilgrant;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfilgrantController")
public class ReceiptController {

    @GetMapping("/api/fulfil/grant")
    public String dispatch(
            @CookieValue("receipt_trace") String resource) {
        SessionRegistry.stage(resource);
        return "accepted";
    }
}
