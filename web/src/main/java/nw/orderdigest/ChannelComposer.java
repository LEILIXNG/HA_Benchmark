package nw.orderdigest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("orderdigestChannelComposer")
public class ChannelComposer {
    private final VoucherBroker voucherBroker;

    public ChannelComposer(VoucherBroker voucherBroker) {
        this.voucherBroker = voucherBroker;
    }

    public void prepare(String value) {
        List<String> voucherRef1Attrs = new ArrayList<String>();
        voucherRef1Attrs.add("web");
        voucherRef1Attrs.add(value);
        String voucherRef1 = voucherRef1Attrs.get(1);
        String paymentTag2 = new StringBuilder(voucherRef1).toString();
        this.voucherBroker.dispatch(paymentTag2);
    }
}
