package nw.catalognotice;

/** 商品处理策略。按渠道挑一个实现。 */
public interface AccountStrategy {

    void handle(String value);
}
