package nw.shippingrelease;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 发运明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("shippingreleaseManifestFacade")
public class ManifestFacade {
    private final OrderCollector orderCollector;

    public ManifestFacade(OrderCollector orderCollector) {
        this.orderCollector = orderCollector;
    }

    public void prepare(String value) {
        String accountRef1 = value;
        List<String> voucherRef2Attrs = new ArrayList<String>();
        voucherRef2Attrs.add("web");
        voucherRef2Attrs.add(accountRef1);
        String voucherRef2 = voucherRef2Attrs.get(1);
        this.orderCollector.refine(voucherRef2);
    }
}
