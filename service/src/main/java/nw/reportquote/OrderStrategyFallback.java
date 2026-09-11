package nw.reportquote;

import org.springframework.stereotype.Service;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
@Service("reportquoteOrderStrategyFallback")
public class OrderStrategyFallback implements OrderStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
