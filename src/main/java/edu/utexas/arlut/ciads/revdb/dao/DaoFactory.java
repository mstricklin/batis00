// CLASSIFICATION NOTICE: This file is UNCLASSIFIED
package edu.utexas.arlut.ciads.revdb.dao;

import javax.sql.DataSource;

public interface DaoFactory {
    DataSource getDS();
    void close();
}
