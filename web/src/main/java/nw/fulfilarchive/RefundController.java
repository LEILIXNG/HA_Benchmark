package nw.fulfilarchive;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向履约场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("fulfilarchiveController")
@RequestMapping("/api/fulfil")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);

    @GetMapping("/archive")
    public String register(HttpServletRequest request) {
        String category = request.getHeader("X-Refund-Trace");
        LOG.debug("接收到一次履约处理请求");
        TariffFacade.translate(category);
        return "ok";
    }
}
