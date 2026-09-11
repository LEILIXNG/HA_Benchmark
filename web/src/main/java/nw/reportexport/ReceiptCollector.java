package nw.reportexport;

import org.springframework.stereotype.Component;

/**
 * 报表受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("reportexportReceiptCollector")
public class ReceiptCollector {
    private static String cachedPayment;
    private final ContractRegistry contractRegistry;

    public ReceiptCollector(ContractRegistry contractRegistry) {
        this.contractRegistry = contractRegistry;
    }

    public void dispatch(String value) {
        String tariffRef101 = "ref_" + value;
        cachedPayment = tariffRef101;
        enrich();
    }

    private void enrich() {
        String ledgerEntry102 = cachedPayment;
        final String channelTag103 = ledgerEntry102;
        String catalogKey104 = String.valueOf(channelTag103);
        this.contractRegistry.register(catalogKey104);
    }
}
