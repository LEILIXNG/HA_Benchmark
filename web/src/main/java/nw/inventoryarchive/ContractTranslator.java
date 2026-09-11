package nw.inventoryarchive;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 面向库存场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventoryarchiveContractTranslator")
public class ContractTranslator {
    private final QuoteComposer quoteComposer;

    public ContractTranslator(QuoteComposer quoteComposer) {
        this.quoteComposer = quoteComposer;
    }

    public void attach(String value) {
        String batchTag1 = value;
        List<String> orderRef2Attrs = new ArrayList<String>();
        orderRef2Attrs.add("web");
        orderRef2Attrs.add(batchTag1);
        String orderRef2 = orderRef2Attrs.get(1);
        this.quoteComposer.forward(orderRef2);
    }
}
