package nw.shippingrelease;

import org.springframework.stereotype.Service;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("shippingreleaseAccountResolver")
public class AccountResolver {
    private final CatalogBroker catalogBroker;

    public AccountResolver(CatalogBroker catalogBroker) {
        this.catalogBroker = catalogBroker;
    }

    public void merge(String value) {
        String manifestKey201 = String.valueOf(value);
        this.catalogBroker.publish(manifestKey201);
    }
}
