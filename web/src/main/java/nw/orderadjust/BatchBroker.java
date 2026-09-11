package nw.orderadjust;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("orderadjustBatchBroker")
public class BatchBroker {

    public void collect(String value) {
        List<String> voucherRef1Attrs = new ArrayList<String>();
        voucherRef1Attrs.add("web");
        voucherRef1Attrs.add(value);
        String voucherRef1 = voucherRef1Attrs.get(1);
        String paymentTag2 = "ref_" + voucherRef1;
        VoucherTranslator.collect(paymentTag2);
    }
}
