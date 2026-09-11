package nw.fulfilclose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("fulfilcloseController")
@RequestMapping("/api/fulfil")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final ChannelRouter channelRouter;

    public CatalogController(ChannelRouter channelRouter) {
        this.channelRouter = channelRouter;
    }

    @GetMapping("/close/{orderNo}")
    public String attach(
            @PathVariable("orderNo") String orderNo) {
        LOG.debug("开始整理履约字段");
        this.channelRouter.normalize(orderNo);
        return "accepted";
    }
}
