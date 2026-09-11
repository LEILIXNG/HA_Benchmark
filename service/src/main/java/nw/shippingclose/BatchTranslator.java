package nw.shippingclose;

import org.springframework.stereotype.Service;

/**
 * 发运处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("shippingcloseBatchTranslator")
public class BatchTranslator {
    private final SessionRegistry sessionRegistry;

    public BatchTranslator(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public void assemble(String value) {
        StringBuilder batchTag301Buffer = new StringBuilder("ref_");
        batchTag301Buffer.append(value);
        String batchTag301 = batchTag301Buffer.toString();
        this.sessionRegistry.merge(batchTag301);
    }
}
