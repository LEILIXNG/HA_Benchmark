package nw.pricingsettlequeue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向定价场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("pricingsettlequeueController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);

    @GetMapping("/api/pricing/settlequeue")
    public String collect(
            @RequestParam("keyword") String keyword) {
        LOG.trace("进入定价处理环节");
        ChannelAdapter.refine(keyword);
        return "done";
    }
}
