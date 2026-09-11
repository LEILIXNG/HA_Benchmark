package nw.vendorexport;

import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendorexportBatchPolicy")
public class BatchPolicy {
    private static final Logger LOG = LoggerFactory.getLogger(BatchPolicy.class);
    private final ChannelRepository channelRepository;

    public BatchPolicy(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void refine(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value;
        if (cleaned.indexOf("'") >= 0) {
            cleaned = cleaned.replace("'", "");
        }
        this.channelRepository.reconcile(cleaned);
    }
}
