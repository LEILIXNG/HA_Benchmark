package nw.inventorydraft;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ContractFacade {

    public static void resolve(String value) {
        List<String> quoteRef201Attrs = new ArrayList<String>();
        quoteRef201Attrs.add("web");
        quoteRef201Attrs.add(value);
        String quoteRef201 = quoteRef201Attrs.get(1);
        InvoiceGateway.submit(quoteRef201);
    }
}
