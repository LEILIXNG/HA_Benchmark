package nw.inventorymerge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("inventorymergeController")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final ContractResolver contractResolver;

    public OrderController(ContractResolver contractResolver) {
        this.contractResolver = contractResolver;
    }

    @GetMapping("/api/inventory/merge")
    public String translate(
            @RequestParam("label") String label) {
        LOG.trace("进入库存处理环节");
        this.contractResolver.resolve(label);
        return "ok";
    }
}
