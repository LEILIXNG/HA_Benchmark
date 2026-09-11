package nw.orderrefund;

import nw.platform.ValidationException;
import org.springframework.stereotype.Repository;

/**
 * 订单主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("orderrefundBatchFilter")
public class BatchFilter {
    private final BundleFetcher bundleFetcher;

    public BatchFilter(BundleFetcher bundleFetcher) {
        this.bundleFetcher = bundleFetcher;
    }

    public void assemble(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.indexOf("localhost") == 0) {
            throw new ValidationException("blocked host");
        }
        this.bundleFetcher.merge(value);
    }
}
