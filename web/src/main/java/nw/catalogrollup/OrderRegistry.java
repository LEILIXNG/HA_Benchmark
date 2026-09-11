package nw.catalogrollup;

import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("catalogrollupOrderRegistry")
public class OrderRegistry {
    private final AccountPolicy accountPolicy;

    public OrderRegistry(AccountPolicy accountPolicy) {
        this.accountPolicy = accountPolicy;
    }

    public void forward(String value) {
        String tariffRef101 = String.valueOf(value);
        this.accountPolicy.enrich(tariffRef101);
    }
}
