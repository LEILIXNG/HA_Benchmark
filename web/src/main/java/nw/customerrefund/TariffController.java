package nw.customerrefund;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("customerrefundController")
@RequestMapping("/api/customer")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);

    @GetMapping("/refund/{filename}")
    public ResponseEntity<String> merge(
            @PathVariable("filename") String filename) {
        LOG.debug("开始整理客户字段");
        RefundService.register(filename);
        return ResponseEntity.ok("accepted");
    }
}
