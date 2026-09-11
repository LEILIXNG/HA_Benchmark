package nw.vendornotice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("vendornoticeContractComposer")
public class ContractComposer {
    private final ContractEnricher contractEnricher;

    public ContractComposer(ContractEnricher contractEnricher) {
        this.contractEnricher = contractEnricher;
    }

    public void normalize(String value) {
        List<String> ledgerEntry1Attrs = new ArrayList<String>();
        ledgerEntry1Attrs.add("web");
        ledgerEntry1Attrs.add(value);
        String ledgerEntry1 = ledgerEntry1Attrs.get(1);
        Map<String, String> channelTag2Attrs = new LinkedHashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("remark", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.getOrDefault("remark", "");
        this.contractEnricher.stage(channelTag2);
    }
}
