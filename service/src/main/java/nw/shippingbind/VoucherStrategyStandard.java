package nw.shippingbind;

import org.springframework.stereotype.Service;

/**
 * 发运的默认处理策略。
 */
@Service("shippingbindVoucherStrategyStandard")
public class VoucherStrategyStandard implements VoucherStrategy {
    private final CatalogCollector catalogCollector;

    public VoucherStrategyStandard(CatalogCollector catalogCollector) {
        this.catalogCollector = catalogCollector;
    }

    @Override
    public void handle(String value) {
        this.catalogCollector.dispatch(value);
    }
}
