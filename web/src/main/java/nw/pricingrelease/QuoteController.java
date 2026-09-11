package nw.pricingrelease;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向定价场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("pricingreleaseController")
@RequestMapping("/api/pricing")
public class QuoteController {

    @GetMapping("/release")
    public String assemble(HttpServletRequest request) {
        String token = request.getHeader("X-Quote-Tenant");
        SessionCollector.prepare(token);
        return "done";
    }
}
