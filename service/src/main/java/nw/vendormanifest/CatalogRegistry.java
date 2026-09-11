package nw.vendormanifest;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("vendormanifestCatalogRegistry")
public class CatalogRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogRegistry.class);
    private String pendingSession;
    private final SessionRepository sessionRepository;

    public CatalogRegistry(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void assemble(String value) {
        LOG.trace("进入供应商处理环节");
        this.reconcile(value);
    }

    private void reconcile(String value) {
        String catalogKey201 = "ref_".concat(value);
        Map<String, String> receiptKey202Attrs = new LinkedHashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("remark", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.getOrDefault("remark", "");
        this.pendingSession = receiptKey202;
        normalize();
    }

    private void normalize() {
        String accountRef203 = this.pendingSession;
        String voucherRef204 = accountRef203;
        this.sessionRepository.attach(voucherRef204);
    }
}
