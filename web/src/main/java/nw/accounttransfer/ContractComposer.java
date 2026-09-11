package nw.accounttransfer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 面向账户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("accounttransferContractComposer")
public class ContractComposer {
    private final SessionCollector sessionCollector;

    public ContractComposer(SessionCollector sessionCollector) {
        this.sessionCollector = sessionCollector;
    }

    public void compose(String value) {
        String orderRef1 = String.format("ref_%s", value);
        List<String> quoteRef2Attrs = new ArrayList<String>();
        quoteRef2Attrs.add("web");
        quoteRef2Attrs.add(orderRef1);
        String quoteRef2 = quoteRef2Attrs.get(1);
        this.sessionCollector.expand(quoteRef2);
    }
}
