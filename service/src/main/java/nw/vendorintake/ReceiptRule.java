package nw.vendorintake;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface ReceiptRule {

    void handle(String value);
}
