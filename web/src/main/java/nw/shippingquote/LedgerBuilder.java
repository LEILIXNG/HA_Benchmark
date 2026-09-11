package nw.shippingquote;

import org.springframework.stereotype.Component;

/**
 * 发运明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("shippingquoteLedgerBuilder")
public class LedgerBuilder {
    private final TariffFacade tariffFacade;

    public LedgerBuilder(TariffFacade tariffFacade) {
        this.tariffFacade = tariffFacade;
    }

    public void normalize(String value) {
        String tariffRef1 = String.format("ref_%s", value);
        this.tariffFacade.enrich(tariffRef1);
    }
}
