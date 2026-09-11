package nw.reportsettle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("reportsettleController")
@RequestMapping("/api/report")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);

    @GetMapping("/settle")
    public String route(
            @RequestParam("query") String query) {
        LOG.debug("报表流程转下一环节");
        ShipmentEnricher.submit(query);
        return "accepted";
    }
}
