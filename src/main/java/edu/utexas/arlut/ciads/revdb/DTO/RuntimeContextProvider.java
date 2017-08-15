// CLASSIFICATION NOTICE: This file is UNCLASSIFIED
package edu.utexas.arlut.ciads.revdb.DTO;


import javax.inject.Inject;
import javax.inject.Provider;

import com.google.inject.Provides;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;

@Slf4j
public class RuntimeContextProvider implements Provider<RuntimeContextProvider.RuntimeContext> {
    @Data
    public static class RuntimeContext {
        // TODO some user identifier...
        int branch;
        int epoch;

        @Inject
        RuntimeContext(SqlSessionFactory ssf) {
            log.info("RuntimeContext ssf ctor");
            this.ssf = ssf;
        }
        RuntimeContext(int branch, int epoch) {
            log.info("RuntimeContext 2 arg ctor");
            this.branch = branch;
            this.epoch = epoch;
        }
        @Inject
        public void setSqlSessionFactory(SqlSessionFactory ssf) {
            log.info("set ssf {}", ssf);
            this.ssf = ssf;
        }
        @Inject
        SqlSessionFactory ssf;

        public void foo() {
            log.info("set RuntimeContext {}", ssf);
        }
    }
    // =================================
    SqlSessionFactory ssf;
    @Inject
    RuntimeContextProvider(SqlSessionFactory ssf) {
        log.info("RuntimeContextProvider ssf ctor {}", ssf);
        this.ssf = ssf;
    }
//    public void set(RuntimeContext rc) {
//        runtimeContextTL.set(rc);
//    }
//

    public void set(int branch, int epoch) {
        runtimeContextTL.set(new RuntimeContext(branch, epoch));
    }
    @Override @Provides
    public RuntimeContext get() {
        return runtimeContextTL.get();
    }


    //    @Provides @ThreadScoped...?
    private ThreadLocal<RuntimeContext> runtimeContextTL = new ThreadLocal<RuntimeContext>() {
        @Override
        protected RuntimeContext initialValue() {
            log.error("Trying to get a RuntimeContext w/o an initial setting");
            return null;
        }
    };
}
