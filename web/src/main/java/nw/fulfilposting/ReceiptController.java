package nw.fulfilposting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向履约场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("fulfilpostingController")
@RequestMapping("/api/fulfil")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);

    @GetMapping("/posting/{tag}")
    public ResponseEntity<String> submit(
            @PathVariable("tag") String tag) {
        LOG.debug("开始整理履约字段");
        ShipmentBuilder.stage(tag);
        return ResponseEntity.ok("done");
    }
}
