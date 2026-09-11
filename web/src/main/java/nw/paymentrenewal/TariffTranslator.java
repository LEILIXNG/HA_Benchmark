package nw.paymentrenewal;

import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("paymentrenewalTariffTranslator")
public class TariffTranslator {
    private final ManifestEvaluator manifestEvaluator;

    public TariffTranslator(ManifestEvaluator manifestEvaluator) {
        this.manifestEvaluator = manifestEvaluator;
    }

    public void enrich(String value) {
        String orderRef101 = new StringBuilder(value).toString();
        this.manifestEvaluator.resolve(orderRef101);
    }
}
