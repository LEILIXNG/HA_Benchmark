package nw.reporttransfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("reporttransferController")
@RequestMapping("/api/report")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);

    @GetMapping("/transfer")
    public String publish(
            @RequestParam("orderNo") String orderNo) {
        LOG.trace("进入报表处理环节");
        ManifestNormalizer.submit(orderNo);
        return "ok";
    }
}
