package nw.vendorintake;

import org.springframework.stereotype.Component;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("vendorintakeAccountTranslator")
public class AccountTranslator {
    private final OrderTranslator orderTranslator;

    public AccountTranslator(OrderTranslator orderTranslator) {
        this.orderTranslator = orderTranslator;
    }

    public void forward(String value) {
        String refundCode1 = "ref_" + value;
        this.orderTranslator.dispatch(refundCode1);
    }
}
