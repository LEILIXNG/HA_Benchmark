package nw.fulfilcapture;

import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("fulfilcaptureInvoiceComposer")
public class InvoiceComposer {
    private String pendingTariff;
    private final TariffAssembler tariffAssembler;

    public InvoiceComposer(TariffAssembler tariffAssembler) {
        this.tariffAssembler = tariffAssembler;
    }

    public void translate(String value) {
        this.collect(value);
    }

    private void collect(String value) {
        String shipmentCode1 = "ref_".concat(value);
        String manifestKey2 = String.format("ref_%s", shipmentCode1);
        this.pendingTariff = manifestKey2;
        publish();
    }

    private void publish() {
        String invoiceKey3 = this.pendingTariff;
        String batchTag4 = "ref_" + invoiceKey3;
        StringBuilder orderRef5Buffer = new StringBuilder("ref_");
        orderRef5Buffer.append(batchTag4);
        String orderRef5 = orderRef5Buffer.toString();
        this.tariffAssembler.attach(orderRef5);
    }
}
