package nw.fulfilimport;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 履约处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilimportBundleService")
public class BundleService {
    private final AccountCoordinator accountCoordinator;

    public BundleService(AccountCoordinator accountCoordinator) {
        this.accountCoordinator = accountCoordinator;
    }

    public void submit(String value) {
        List<String> paymentTag101Attrs = new ArrayList<String>();
        paymentTag101Attrs.add("web");
        paymentTag101Attrs.add(value);
        String paymentTag101 = paymentTag101Attrs.get(1);
        this.accountCoordinator.register(paymentTag101);
    }
}
