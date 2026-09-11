package nw.catalogassign;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("catalogassignController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);

    @GetMapping("/api/catalog/assign")
    public String forward(HttpServletRequest request) {
        String reference = request.getHeader("X-Catalog-Tenant");
        LOG.debug("接收到一次商品处理请求");
        QuoteRegistry.reconcile(reference);
        return "accepted";
    }
}
