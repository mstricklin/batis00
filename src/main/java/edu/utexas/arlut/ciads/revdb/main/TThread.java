// CLASSIFICATION NOTICE: This file is UNCLASSIFIED
package edu.utexas.arlut.ciads.revdb.main;

import javax.inject.Inject;
import javax.inject.Provider;

import edu.utexas.arlut.ciads.revdb.DTO.RuntimeContextProvider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TThread implements Runnable {
//    @Inject
    RuntimeContextProvider rcp2;

    private final Provider<RC> rcp;

    @Inject
    TThread(Provider<RC> rcp, RuntimeContextProvider rcp2) {
        log.info("Thread id: {}", Thread.currentThread().getId());

        this.rcp = rcp;
        log.info("Injected Provider<RC> {}", rcp);
        RC rc = rcp.get();
        log.info("RC: {}", rc);

        this.rcp2 = rcp2;
        log.info("Injected RuntimeContextProvider {}", rcp2);
        rcp2.set(1, 1);
        RuntimeContextProvider.RuntimeContext rc2 = rcp2.get();
        log.info("get RuntimeContextProvider.RuntimeContext {}", rc2);

    }

    @Override
    public void run() {
        log.info("Thread id: {}", Thread.currentThread().getId());

        log.info("in thread: Injected Provider<RC> {}", rcp);
        RC rc = rcp.get();
        log.info("in thread: RC: {}", rc);

        log.info("in thread: Injected RuntimeContextProvider {}", rcp2);
        rcp2.set(2, 2);
        RuntimeContextProvider.RuntimeContext rc2 = rcp2.get();
        log.info("in thread: get RuntimeContextProvider.RuntimeContext {}", rc2);
    }
}
