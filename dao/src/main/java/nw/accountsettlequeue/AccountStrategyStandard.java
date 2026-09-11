package nw.accountsettlequeue;

import org.springframework.stereotype.Repository;

/**
 * 账户的默认处理策略。
 */
@Repository("accountsettlequeueAccountStrategyStandard")
public class AccountStrategyStandard implements AccountStrategy {
    private final CatalogEnricher catalogEnricher;

    public AccountStrategyStandard(CatalogEnricher catalogEnricher) {
        this.catalogEnricher = catalogEnricher;
    }

    @Override
    public void handle(String value) {
        this.catalogEnricher.submit(value);
    }
}
