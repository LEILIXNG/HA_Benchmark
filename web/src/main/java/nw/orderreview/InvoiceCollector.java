package nw.orderreview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("orderreviewInvoiceCollector")
public class InvoiceCollector {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceCollector.class);
    private static String cachedPayment;
    private final ChannelAssembler channelAssembler;

    public InvoiceCollector(ChannelAssembler channelAssembler) {
        this.channelAssembler = channelAssembler;
    }

    public void route(String value) {
        LOG.debug("开始整理订单字段");
        String voucherRef101 = String.format("ref_%s", value);
        String paymentTag102 = String.valueOf(voucherRef101);
        cachedPayment = paymentTag102;
        submit();
    }

    private void submit() {
        String refundCode103 = cachedPayment;
        StringBuilder shipmentCode104Buffer = new StringBuilder("ref_");
        shipmentCode104Buffer.append(refundCode103);
        String shipmentCode104 = shipmentCode104Buffer.toString();
        this.channelAssembler.publish(shipmentCode104);
    }
}
