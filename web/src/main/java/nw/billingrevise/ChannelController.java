package nw.billingrevise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingreviseController")
public class ChannelController {

    @GetMapping("/api/billing/revise/{label}")
    public String assemble(
            @PathVariable("label") String label) {
        ReceiptEnricher.resolve(label);
        return "ok";
    }
}
