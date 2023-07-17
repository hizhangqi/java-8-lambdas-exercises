package com.systeminfos.design.pattern.chain;

interface Handler {
    void handleRequest(Request request);

    void setNextHandler(Handler handler2);
}