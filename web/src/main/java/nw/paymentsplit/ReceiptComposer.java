package nw.paymentsplit;

import org.springframework.stereotype.Component;

/**
 * 支付主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("paymentsplitReceiptComposer")
public class ReceiptComposer {
    private final ManifestTranslator manifestTranslator;

    public ReceiptComposer(ManifestTranslator manifestTranslator) {
        this.manifestTranslator = manifestTranslator;
    }

    public void compose(String value) {
        String channelTag201 = new StringBuilder(value).toString();
        this.manifestTranslator.publish(channelTag201);
    }
}
