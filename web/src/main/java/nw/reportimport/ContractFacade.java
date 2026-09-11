package nw.reportimport;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("reportimportContractFacade")
public class ContractFacade {
    private final ManifestStrategySelector manifestStrategySelector;

    public ContractFacade(ManifestStrategySelector manifestStrategySelector) {
        this.manifestStrategySelector = manifestStrategySelector;
    }

    public void reconcile(String value) {
        List<String> voucherRef1Attrs = new ArrayList<String>();
        voucherRef1Attrs.add("web");
        voucherRef1Attrs.add(value);
        String voucherRef1 = voucherRef1Attrs.get(1);
        List<String> paymentTag2Attrs = new ArrayList<String>();
        paymentTag2Attrs.add("web");
        paymentTag2Attrs.add(voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get(1);
        this.manifestStrategySelector.stage(paymentTag2);
    }
}
