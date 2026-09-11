package nw.fulfilreopen;

/**
 * 履约处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BatchBuilder {

    public static void refine(String value) {
        String paymentTag401 = String.valueOf(value);
        RefundEvaluator.submit(paymentTag401);
    }
}
