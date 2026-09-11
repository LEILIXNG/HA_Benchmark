package nw.reportquote;

import org.springframework.stereotype.Service;

/**
 * 报表处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("reportquoteCatalogFacade")
public class CatalogFacade {
    private final PaymentRegistry paymentRegistry;

    public CatalogFacade(PaymentRegistry paymentRegistry) {
        this.paymentRegistry = paymentRegistry;
    }

    public void resolve(String value) {
        String catalogKey301 = String.format("ref_%s", value);
        this.paymentRegistry.translate(catalogKey301);
    }
}
