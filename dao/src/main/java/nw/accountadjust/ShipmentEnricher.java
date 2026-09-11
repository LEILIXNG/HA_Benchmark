package nw.accountadjust;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 面向账户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("accountadjustShipmentEnricher")
public class ShipmentEnricher {
    private final QuoteEvaluator quoteEvaluator;

    public ShipmentEnricher(QuoteEvaluator quoteEvaluator) {
        this.quoteEvaluator = quoteEvaluator;
    }

    public void forward(String value) {
        List<String> manifestKey301Attrs = new ArrayList<String>();
        manifestKey301Attrs.add("web");
        manifestKey301Attrs.add(value);
        String manifestKey301 = manifestKey301Attrs.get(1);
        String invoiceKey302 = "ref_" + manifestKey301;
        this.quoteEvaluator.forward(invoiceKey302);
    }
}
