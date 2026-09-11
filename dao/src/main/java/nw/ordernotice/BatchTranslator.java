package nw.ordernotice;

import org.springframework.stereotype.Repository;

/**
 * 订单明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("ordernoticeBatchTranslator")
public class BatchTranslator {

    public void resolve(String value) {
        String batchTag501 = String.valueOf(value);
        ReceiptEvaluator.register(batchTag501);
    }
}
