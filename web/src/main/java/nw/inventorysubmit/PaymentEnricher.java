package nw.inventorysubmit;

import java.util.ArrayList;
import java.util.List;

/**
 * 面向库存场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class PaymentEnricher {

    public static void dispatch(String value) {
        List<String> accountRef1Attrs = new ArrayList<String>();
        accountRef1Attrs.add("web");
        accountRef1Attrs.add(value);
        String accountRef1 = accountRef1Attrs.get(1);
        InvoiceBuilder.assemble(accountRef1);
    }
}
