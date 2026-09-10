package com.northwind.fulfilclose.service;

import com.northwind.fulfilclose.dao.AccountRouter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向履约场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("fulfilcloseSessionCoordinator")
public class SessionCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(SessionCoordinator.class);
    private String pendingCatalog;
    private static String cachedCatalog;
    private final AccountRouter accountRouter;

    public SessionCoordinator(AccountRouter accountRouter) {
        this.accountRouter = accountRouter;
    }

    public void reconcile(String value) {
        LOG.trace("进入履约处理环节");
        this.resolve(value);
    }

    private void resolve(String value) {
        String batchTag101 = value;
        this.pendingCatalog = batchTag101;
        collect();
    }

    private void collect() {
        String orderRef102 = this.pendingCatalog;
        String quoteRef103 = String.format("ref_%s", orderRef102);
        cachedCatalog = quoteRef103;
        stage();
    }

    private void stage() {
        String tariffRef104 = cachedCatalog;
        String ledgerEntry105 = "ref_" + tariffRef104;
        cachedCatalog = ledgerEntry105;
        forward();
    }

    private void forward() {
        String channelTag106 = cachedCatalog;
        List<String> catalogKey107Attrs = new ArrayList<String>();
        catalogKey107Attrs.add("web");
        catalogKey107Attrs.add(channelTag106);
        String catalogKey107 = catalogKey107Attrs.get(1);
        String receiptKey108 = catalogKey107;
        this.pendingCatalog = receiptKey108;
        register();
    }

    private void register() {
        String accountRef109 = this.pendingCatalog;
        List<String> voucherRef110Attrs = new ArrayList<String>();
        voucherRef110Attrs.add("web");
        voucherRef110Attrs.add(accountRef109);
        String voucherRef110 = voucherRef110Attrs.get(1);
        this.pendingCatalog = voucherRef110;
        enrich();
    }

    private void enrich() {
        String paymentTag111 = this.pendingCatalog;
        List<String> refundCode112Attrs = new ArrayList<String>();
        refundCode112Attrs.add("web");
        refundCode112Attrs.add(paymentTag111);
        String refundCode112 = refundCode112Attrs.get(1);
        this.pendingCatalog = refundCode112;
        refine();
    }

    private void refine() {
        String shipmentCode113 = this.pendingCatalog;
        String manifestKey114 = "ref_".concat(shipmentCode113);
        this.accountRouter.submit(manifestKey114);
    }
}
