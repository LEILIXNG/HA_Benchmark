package com.habench.paymentlookup.web;

public interface ChannelStrategy {
    void handle(String value);
}
