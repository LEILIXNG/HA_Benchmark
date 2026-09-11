package nw.reportbind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("reportbindLedgerPolicy")
public class LedgerPolicy {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerPolicy.class);
    private final ContractLoader contractLoader;

    public LedgerPolicy(ContractLoader contractLoader) {
        this.contractLoader = contractLoader;
    }

    public void reconcile(String value) {
        // 去掉相对路径写法，统一按根目录拼
        String cleaned = value.contains("../") ? value.replace("../", "") : value;
        this.contractLoader.register(cleaned);
    }
}
