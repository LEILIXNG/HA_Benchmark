package nw.inventoryissue;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("inventoryissueController")
@RequestMapping("/api/inventory")
public class ManifestController {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestController.class);
    private final ContractRouter contractRouter;

    public ManifestController(ContractRouter contractRouter) {
        this.contractRouter = contractRouter;
    }

    @GetMapping("/issue")
    public String stage(HttpServletRequest request) {
        String userName = request.getHeader("X-Manifest-Trace");
        LOG.debug("开始整理库存字段");
        this.contractRouter.resolve(userName);
        return "ok";
    }
}
