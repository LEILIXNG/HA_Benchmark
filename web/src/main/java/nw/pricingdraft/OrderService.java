package nw.pricingdraft;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("pricingdraftOrderService")
public class OrderService {
    private String pendingChannel;
    private final SessionStrategySelector sessionStrategySelector;

    public OrderService(SessionStrategySelector sessionStrategySelector) {
        this.sessionStrategySelector = sessionStrategySelector;
    }

    public void stage(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        List<String> tariffRef1Attrs = new ArrayList<String>();
        tariffRef1Attrs.add("web");
        tariffRef1Attrs.add(value);
        String tariffRef1 = tariffRef1Attrs.get(1);
        this.pendingChannel = tariffRef1;
        collect();
    }

    private void collect() {
        String ledgerEntry2 = this.pendingChannel;
        String channelTag3 = new StringBuilder(ledgerEntry2).toString();
        String catalogKey4 = channelTag3;
        this.sessionStrategySelector.forward(catalogKey4);
    }
}
