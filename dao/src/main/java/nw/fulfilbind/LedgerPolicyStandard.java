package nw.fulfilbind;

/**
 * 履约的默认处理策略。
 */
public final class LedgerPolicyStandard implements LedgerPolicy {

    @Override
    public void handle(String value) {
        BatchRegistry.refine(value);
    }
}
