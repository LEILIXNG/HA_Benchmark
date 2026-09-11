package nw.accountsplit;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("accountsplitController")
@RequestMapping("/api/account")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final ManifestNormalizer manifestNormalizer;

    public ShipmentController(ManifestNormalizer manifestNormalizer) {
        this.manifestNormalizer = manifestNormalizer;
    }

    @GetMapping("/split")
    public String publish(HttpServletRequest request) {
        String filename = request.getHeader("X-Shipment-Reference");
        LOG.debug("开始整理账户字段");
        this.manifestNormalizer.normalize(filename);
        return "ok";
    }
}
