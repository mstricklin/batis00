// CLASSIFICATION NOTICE: This file is UNCLASSIFIED
package edu.utexas.arlut.ciads.revdb.main;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;

@Slf4j
public class RC {

    // TODO some user identifier...
    int branch;
    int epoch;
    SqlSessionFactory ssf;

    @Inject
    RC(SqlSessionFactory ssf) {
        log.info("RuntimeContext ssf ctor");
        this.ssf = ssf;
    }
}
