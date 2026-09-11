package nw.inventoryapprove;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 库存主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("inventoryapproveBatchCoordinator")
public class BatchCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchCoordinator.class);
    private final BatchFilter batchFilter;

    public BatchCoordinator(BatchFilter batchFilter) {
        this.batchFilter = batchFilter;
    }

    public void compose(String value) {
        LOG.debug("开始整理库存字段");
        Map<String, String> receiptKey401Attrs = new LinkedHashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("detail", value);
        String receiptKey401 = receiptKey401Attrs.getOrDefault("detail", "");
        final String accountRef402 = receiptKey401;
        this.batchFilter.enrich(accountRef402);
    }
}
