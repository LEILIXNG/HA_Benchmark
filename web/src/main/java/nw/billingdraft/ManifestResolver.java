package nw.billingdraft;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("billingdraftManifestResolver")
public class ManifestResolver {
    private final ManifestService manifestService;

    public ManifestResolver(ManifestService manifestService) {
        this.manifestService = manifestService;
    }

    public void stage(String value) {
        StringBuilder invoiceKey101Buffer = new StringBuilder("ref_");
        invoiceKey101Buffer.append(value);
        String invoiceKey101 = invoiceKey101Buffer.toString();
        Map<String, String> batchTag102Attrs = new LinkedHashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("remark", invoiceKey101);
        String batchTag102 = batchTag102Attrs.getOrDefault("remark", "");
        this.manifestService.attach(batchTag102);
    }
}
