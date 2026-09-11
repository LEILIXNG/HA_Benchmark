package nw.fulfilimport;

import org.springframework.stereotype.Repository;

/**
 * 面向履约场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("fulfilimportChannelService")
public class ChannelService {

    public void attach(String value) {
        String paymentTag401 = String.valueOf(value);
        CatalogExecutor.expand(paymentTag401);
    }
}
