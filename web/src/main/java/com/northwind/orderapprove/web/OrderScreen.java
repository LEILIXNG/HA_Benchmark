package com.northwind.orderapprove.web;

import com.northwind.platform.ValidationException;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("orderapproveOrderScreen")
public class OrderScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final CatalogEvaluator catalogEvaluator;

    public OrderScreen(CatalogEvaluator catalogEvaluator) {
        this.catalogEvaluator = catalogEvaluator;
    }

    public void normalize(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new ValidationException("rejected input");
        }
        this.catalogEvaluator.translate(value);
    }
}
