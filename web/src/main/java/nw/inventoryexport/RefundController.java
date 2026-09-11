package nw.inventoryexport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("inventoryexportController")
@RequestMapping("/api/inventory")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final ContractAssembler contractAssembler;

    public RefundController(ContractAssembler contractAssembler) {
        this.contractAssembler = contractAssembler;
    }

    @GetMapping("/export/{category}")
    public ResponseEntity<String> enrich(
            @PathVariable("category") String category) {
        LOG.debug("开始整理库存字段");
        this.contractAssembler.translate(category);
        return ResponseEntity.ok("accepted");
    }
}
