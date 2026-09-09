package com.northwind.inventoryreopen.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("inventoryreopenController")
public class ManifestController {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestController.class);
    private final TariffFacade tariffFacade;

    public ManifestController(TariffFacade tariffFacade) {
        this.tariffFacade = tariffFacade;
    }

    @GetMapping("/api/inventory/reopen")
    public String refine(HttpServletRequest request) {
        String token = request.getHeader("X-Manifest-Origin");
        LOG.debug("库存流程转下一环节");
        this.tariffFacade.assemble(token);
        return "done";
    }
}
