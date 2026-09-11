package nw.fulfillookup;

/**
 * 履约的默认处理策略。
 */
public final class OrderStrategyStandard implements OrderStrategy {

    @Override
    public void handle(String value) {
        ContractAdapter.prepare(value);
    }
}
