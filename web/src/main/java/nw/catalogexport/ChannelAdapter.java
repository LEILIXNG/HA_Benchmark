package nw.catalogexport;

import org.springframework.stereotype.Component;

/**
 * 商品受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogexportChannelAdapter")
public class ChannelAdapter {

    public void normalize(String value) {
        String voucherRef1 = String.valueOf(value);
        InvoiceAdapter.merge(voucherRef1);
    }
}
