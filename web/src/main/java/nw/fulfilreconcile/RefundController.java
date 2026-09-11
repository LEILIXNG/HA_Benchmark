package nw.fulfilreconcile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("fulfilreconcileController")
@RequestMapping("/api/fulfil")
public class RefundController {
    private final ContractFacade contractFacade;

    public RefundController(ContractFacade contractFacade) {
        this.contractFacade = contractFacade;
    }

    @GetMapping("/reconcile/{target}")
    public String refine(
            @PathVariable("target") String target) {
        this.contractFacade.prepare(target);
        return "accepted";
    }
}
