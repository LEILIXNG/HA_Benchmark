package nw.fulfilexport;

/** 履约处理策略。按渠道挑一个实现。 */
public interface ContractPlan {

    void handle(String value);
}
