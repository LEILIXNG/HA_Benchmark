package nw.inventorycapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("inventorycaptureController")
@RequestMapping("/api/inventory")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);

    @GetMapping("/capture/{orderNo}")
    public String expand(
            @PathVariable("orderNo") String orderNo) {
        LOG.debug("库存流程转下一环节");
        InvoiceResolver.forward(orderNo);
        return "accepted";
    }
}
