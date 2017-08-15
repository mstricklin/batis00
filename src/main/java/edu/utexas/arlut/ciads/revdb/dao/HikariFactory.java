package edu.utexas.arlut.ciads.revdb.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class HikariFactory implements DataSourceFactory {

    public HikariFactory() {
        ds_ = null;
        cfg_ = new HikariConfig();
    }

    public HikariFactory(Properties props) {
        ds_ = new HikariDataSource(new HikariConfig(props));
        cfg_ = new HikariConfig();
        log.info("Hikari DS: {}");
    }

    public HikariFactory(String propFile) {
        ds_ = new HikariDataSource(new HikariConfig(propFile));
        cfg_ = new HikariConfig();
        log.info("Hikari DS: {}");
    }

    @Override
    public DataSource getDataSource() {
        if (null == ds_)
            ds_ = new HikariDataSource(cfg_);
        return ds_;
    }

    @Override
    public void setProperties(Properties props) {
        for (Map.Entry<Object, Object> e : props.entrySet()) {
            log.info("Hikari prop: {} => {}", e.getKey(), e.getValue());
        }
        cfg_.setJdbcUrl(props.getProperty("jdbcUrl", ""));

        cfg_.setUsername(props.getProperty("username", "sa"));
        cfg_.setPassword(props.getProperty("password", ""));

        cfg_.setPoolName(props.getProperty("poolName", "pool-name"));

        int minSize = Integer.valueOf(props.getProperty("minimumIdle", "1"));
        cfg_.setMinimumIdle(minSize);

        int maxPool = Integer.valueOf(props.getProperty("maximumPoolSize", "3"));
        cfg_.setMaximumPoolSize(maxPool);

        boolean autoCommit = Boolean.valueOf(props.getProperty("autoCommit", "false"));
        cfg_.setAutoCommit(autoCommit);
    }

    private HikariDataSource ds_;
    private HikariConfig cfg_;
}
