package nw.catalogsync;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("catalogsyncController")
@RequestMapping("/api/catalog")
public class SessionController {
    private final ContractCoordinator contractCoordinator;

    public SessionController(ContractCoordinator contractCoordinator) {
        this.contractCoordinator = contractCoordinator;
    }

    @GetMapping("/sync")
    public ResponseEntity<String> register(HttpServletRequest request) {
        String userName = request.getHeader("X-Session-Reference");
        this.contractCoordinator.normalize(userName);
        return ResponseEntity.ok("accepted");
    }
}
