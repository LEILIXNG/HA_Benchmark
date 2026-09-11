package nw.reportsubmit;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reportsubmitOrderCollector")
public class OrderCollector {
    private final VoucherService voucherService;

    public OrderCollector(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    public void refine(String value) {
        List<String> paymentTag1Attrs = new ArrayList<String>();
        paymentTag1Attrs.add("web");
        paymentTag1Attrs.add(value);
        String paymentTag1 = paymentTag1Attrs.get(1);
        String refundCode2 = new StringBuilder(paymentTag1).toString();
        this.voucherService.merge(refundCode2);
    }
}
