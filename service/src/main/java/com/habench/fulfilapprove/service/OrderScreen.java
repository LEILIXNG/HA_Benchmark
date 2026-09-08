package com.habench.fulfilapprove.service;

import com.habench.fulfilapprove.service.ShipmentRouter;
import java.util.regex.Pattern;

public final class OrderScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void compose(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ShipmentRouter.stage(value);
    }
}
