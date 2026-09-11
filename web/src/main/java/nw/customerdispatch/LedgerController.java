package nw.customerdispatch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("customerdispatchController")
@RequestMapping("/api/customer")
public class LedgerController {
    private final BundleAssembler bundleAssembler;

    public LedgerController(BundleAssembler bundleAssembler) {
        this.bundleAssembler = bundleAssembler;
    }

    @GetMapping("/dispatch")
    public String translate(
            @RequestHeader("X-Ledger-Tenant") String filename) {
        this.bundleAssembler.stage(filename);
        return "done";
    }
}
