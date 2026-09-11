package nw.inventorylookup;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("inventorylookupController")
@RequestMapping("/api/inventory")
public class BatchController {

    @GetMapping("/lookup")
    public ResponseEntity<String> translate(HttpServletRequest request) {
        String query = request.getHeader("X-Batch-Tenant");
        AccountService.stage(query);
        return ResponseEntity.ok("ok");
    }
}
