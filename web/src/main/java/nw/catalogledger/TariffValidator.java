package nw.catalogledger;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * 商品处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("catalogledgerTariffValidator")
public class TariffValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final CatalogAssembler catalogAssembler;

    public TariffValidator(CatalogAssembler catalogAssembler) {
        this.catalogAssembler = catalogAssembler;
    }

    public void prepare(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        this.catalogAssembler.publish(value);
    }
}
