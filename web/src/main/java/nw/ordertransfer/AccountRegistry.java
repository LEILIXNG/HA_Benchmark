package nw.ordertransfer;

import org.springframework.stereotype.Component;

/**
 * 面向订单场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("ordertransferAccountRegistry")
public class AccountRegistry {
    private final ManifestResolver manifestResolver;

    public AccountRegistry(ManifestResolver manifestResolver) {
        this.manifestResolver = manifestResolver;
    }

    public void expand(String value) {
        String shipmentCode101 = new StringBuilder(value).toString();
        this.manifestResolver.collect(shipmentCode101);
    }
}
