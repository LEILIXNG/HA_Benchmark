package nw.orderexport;

import java.util.regex.Pattern;
import org.springframework.stereotype.Repository;

/**
 * 面向订单场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("orderexportShipmentScreen")
public class ShipmentScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final BundleLoader bundleLoader;

    public ShipmentScreen(BundleLoader bundleLoader) {
        this.bundleLoader = bundleLoader;
    }

    public void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        this.bundleLoader.expand(value);
    }
}
