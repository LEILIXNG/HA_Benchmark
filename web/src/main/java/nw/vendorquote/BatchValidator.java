package nw.vendorquote;

import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("vendorquoteBatchValidator")
public class BatchValidator {
    private final QuoteFetcher quoteFetcher;

    public BatchValidator(QuoteFetcher quoteFetcher) {
        this.quoteFetcher = quoteFetcher;
    }

    public void refine(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.toLowerCase().startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        this.quoteFetcher.refine(value);
    }
}
