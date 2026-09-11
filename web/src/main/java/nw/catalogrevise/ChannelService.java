package nw.catalogrevise;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("catalogreviseChannelService")
public class ChannelService {
    private final InvoiceRepository invoiceRepository;

    public ChannelService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void normalize(String value) {
        Map<String, String> channelTag101Attrs = new LinkedHashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("detail", value);
        String channelTag101 = channelTag101Attrs.getOrDefault("detail", "");
        this.invoiceRepository.compose(channelTag101);
    }
}
