package nw.customerreview;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("customerreviewPaymentBuilder")
public class PaymentBuilder {
    private final TariffScreen tariffScreen;

    public PaymentBuilder(TariffScreen tariffScreen) {
        this.tariffScreen = tariffScreen;
    }

    public void compose(String value) {
        List<String> paymentTag501Attrs = new ArrayList<String>();
        paymentTag501Attrs.add("web");
        paymentTag501Attrs.add(value);
        String paymentTag501 = paymentTag501Attrs.get(1);
        this.tariffScreen.expand(paymentTag501);
    }
}
