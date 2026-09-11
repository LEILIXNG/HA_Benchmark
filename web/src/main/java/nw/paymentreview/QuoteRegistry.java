package nw.paymentreview;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 支付明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("paymentreviewQuoteRegistry")
public class QuoteRegistry {
    private final ContractTranslator contractTranslator;

    public QuoteRegistry(ContractTranslator contractTranslator) {
        this.contractTranslator = contractTranslator;
    }

    public void dispatch(String value) {
        List<String> voucherRef1Attrs = new ArrayList<String>();
        voucherRef1Attrs.add("web");
        voucherRef1Attrs.add(value);
        String voucherRef1 = voucherRef1Attrs.get(1);
        this.contractTranslator.expand(voucherRef1);
    }
}
