package nw.inventoryissue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 面向库存场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("inventoryissueOrderAssembler")
public class OrderAssembler {
    private final ManifestLoader manifestLoader;

    public OrderAssembler(ManifestLoader manifestLoader) {
        this.manifestLoader = manifestLoader;
    }

    public void translate(String value) {
        Map<String, String> ledgerEntry501Attrs = new LinkedHashMap<String, String>();
        ledgerEntry501Attrs.put("channel", "web");
        ledgerEntry501Attrs.put("detail", value);
        String ledgerEntry501 = ledgerEntry501Attrs.getOrDefault("detail", "");
        Map<String, String> channelTag502Attrs = new HashMap<String, String>();
        channelTag502Attrs.put("channel", "web");
        channelTag502Attrs.put("remark", ledgerEntry501);
        String channelTag502 = channelTag502Attrs.get("remark");
        this.manifestLoader.register(channelTag502);
    }
}
