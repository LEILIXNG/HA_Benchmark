package nw.catalogsplit;

import org.springframework.stereotype.Service;

/**
 * 商品主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("catalogsplitChannelAdapter")
public class ChannelAdapter {
    private final BatchTranslator batchTranslator;

    public ChannelAdapter(BatchTranslator batchTranslator) {
        this.batchTranslator = batchTranslator;
    }

    public void expand(String value) {
        String shipmentCode201 = value;
        String manifestKey202 = String.valueOf(shipmentCode201);
        this.batchTranslator.forward(manifestKey202);
    }
}
