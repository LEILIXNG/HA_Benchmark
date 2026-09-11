package nw.reportcapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("reportcaptureController")
@RequestMapping("/api/report")
public class VoucherController {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherController.class);

    @GetMapping("/capture")
    public ResponseEntity<String> assemble(
            @RequestParam("keyword") String keyword) {
        LOG.debug("报表流程转下一环节");
        OrderRegistry.publish(keyword);
        return ResponseEntity.ok("done");
    }
}
