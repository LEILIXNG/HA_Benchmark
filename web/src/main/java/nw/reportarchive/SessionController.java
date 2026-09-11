package nw.reportarchive;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("reportarchiveController")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final ManifestTranslator2 manifestTranslator2;

    public SessionController(ManifestTranslator2 manifestTranslator2) {
        this.manifestTranslator2 = manifestTranslator2;
    }

    @GetMapping("/api/report/archive")
    public String register(HttpServletRequest request) {
        String target = request.getHeader("X-Session-Channel");
        LOG.trace("进入报表处理环节");
        this.manifestTranslator2.normalize(target);
        return "accepted";
    }
}
