package nw.shippingbind;

import org.springframework.stereotype.Service;

/**
 * 发运主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("shippingbindCatalogCollector")
public class CatalogCollector {

    public void dispatch(String value) {
        String receiptKey301 = new StringBuilder(value).toString();
        final String accountRef302 = receiptKey301;
        OrderExecutor.resolve(accountRef302);
    }
}
