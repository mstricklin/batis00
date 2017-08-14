// CLASSIFICATION NOTICE: This file is UNCLASSIFIED
package edu.utexas.arlut.ciads.revdb.impl;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;

@Slf4j
public class SchemaVersionManager {
    public SchemaVersionManager(final DataSource ds) {
        ds_ = ds;
    }
    // =================================
    public void migrate() {
        log.debug("SchemaVersionManager.migrate");

        Flyway flyway = new Flyway();
        flyway.setDataSource(ds_);
//        flyway.setDataSource("jdbc:hsqldb:file:/Users/boobear/scratch/amt.db/amt", "sa", "sa");
        flyway.setLocations("classpath:db/hsqldb/migration");
        flyway.clean();
        flyway.migrate();
    }
    private DataSource ds_;

}
