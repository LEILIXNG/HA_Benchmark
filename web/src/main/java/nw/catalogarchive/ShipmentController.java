package nw.catalogarchive;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向商品场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("catalogarchiveController")
@RequestMapping("/api/catalog")
public class ShipmentController {
    private final BundleFacade bundleFacade;

    public ShipmentController(BundleFacade bundleFacade) {
        this.bundleFacade = bundleFacade;
    }

    @GetMapping("/archive")
    public ResponseEntity<String> refine(HttpServletRequest request) {
        String tag = request.getHeader("X-Shipment-Context");
        this.bundleFacade.collect(tag);
        return ResponseEntity.ok("ok");
    }
}
