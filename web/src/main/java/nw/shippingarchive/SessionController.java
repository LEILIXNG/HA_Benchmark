package nw.shippingarchive;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向发运场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("shippingarchiveController")
@RequestMapping("/api/shipping")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final CatalogCollector catalogCollector;

    public SessionController(CatalogCollector catalogCollector) {
        this.catalogCollector = catalogCollector;
    }

    @GetMapping("/archive")
    public String register(HttpServletRequest request) {
        String keyword = request.getHeader("X-Session-Client");
        LOG.debug("发运流程转下一环节");
        this.catalogCollector.submit(keyword);
        return "done";
    }
}
