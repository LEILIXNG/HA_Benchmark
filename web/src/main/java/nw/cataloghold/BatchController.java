package nw.cataloghold;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("catalogholdController")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);

    @GetMapping("/api/catalog/hold")
    public String expand(HttpServletRequest request) {
        String token = request.getHeader("X-Batch-Client");
        LOG.debug("商品流程转下一环节");
        BatchRegistry.resolve(token);
        return "ok";
    }
}
