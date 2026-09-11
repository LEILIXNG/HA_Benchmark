package nw.reportsplit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("reportsplitController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);

    @GetMapping("/api/report/split")
    public String stage(
            @RequestHeader("X-Receipt-Correlation") String filename) {
        LOG.debug("开始整理报表字段");
        TariffCollector.attach(filename);
        return "ok";
    }
}
