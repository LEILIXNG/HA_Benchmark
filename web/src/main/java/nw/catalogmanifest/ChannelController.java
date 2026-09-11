package nw.catalogmanifest;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("catalogmanifestController")
public class ChannelController {
    private final SessionFacade sessionFacade;

    public ChannelController(SessionFacade sessionFacade) {
        this.sessionFacade = sessionFacade;
    }

    @GetMapping("/api/catalog/manifest")
    public String refine(HttpServletRequest request) {
        String reference = request.getHeader("X-Channel-Client");
        this.sessionFacade.attach(reference);
        return "done";
    }
}
