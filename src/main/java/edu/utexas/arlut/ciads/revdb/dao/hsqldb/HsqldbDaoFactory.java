// CLASSIFICATION NOTICE: This file is UNCLASSIFIED
package edu.utexas.arlut.ciads.revdb.dao.hsqldb;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

import edu.utexas.arlut.ciads.revdb.ConnectionPoolManager;
import edu.utexas.arlut.ciads.revdb.dao.DaoFactory;
import edu.utexas.arlut.ciads.revdb.impl.SchemaVersionManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HsqldbDaoFactory implements DaoFactory {

    public static HsqldbDaoFactory make(Properties hikariConfig) {
        return new HsqldbDaoFactory(hikariConfig);
    }
    // =================================
    private HsqldbDaoFactory(Properties hikariConfig_) {
        cpm = new ConnectionPoolManager(hikariConfig_);

        log.trace("HsqldbDaoFactory CPM: {}", cpm);

        new SchemaVersionManager(cpm.getDataSource()).migrate();
        log.trace("Done migrate");

        ds = cpm.getDataSource();
    }

    @Override
    public DataSource getDS() {
        return ds;
    }
    // =================================
    @Override
    public void close() {
        try {
            if (null != cpm) {
                log.debug("Shutting down connection...");
                cpm.close();
            }
        } catch (SQLException e) {
            log.error("Error shutting down DB", e);
        }
    }
    // =================================
    private final ConnectionPoolManager cpm;
    private final DataSource ds;
}
