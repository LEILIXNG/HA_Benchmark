package nw.vendorrelease;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("vendorreleaseController")
@RequestMapping("/api/vendor")
public class LedgerController {
    private final ManifestNormalizer manifestNormalizer;

    public LedgerController(ManifestNormalizer manifestNormalizer) {
        this.manifestNormalizer = manifestNormalizer;
    }

    @GetMapping("/release/{label}")
    public String submit(
            @PathVariable("label") String label) {
        this.manifestNormalizer.assemble(label);
        return "accepted";
    }
}
