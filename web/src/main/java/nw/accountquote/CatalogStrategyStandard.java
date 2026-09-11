package nw.accountquote;

import org.springframework.stereotype.Component;

/**
 * 账户的默认处理策略。
 */
@Component("accountquoteCatalogStrategyStandard")
public class CatalogStrategyStandard implements CatalogStrategy {
    private final TariffRouter tariffRouter;

    public CatalogStrategyStandard(TariffRouter tariffRouter) {
        this.tariffRouter = tariffRouter;
    }

    @Override
    public void handle(String value) {
        this.tariffRouter.normalize(value);
    }
}
