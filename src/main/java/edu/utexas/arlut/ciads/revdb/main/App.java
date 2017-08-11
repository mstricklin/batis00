// CLASSIFICATION NOTICE: This file is UNCLASSIFIED
package edu.utexas.arlut.ciads.revdb.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import edu.utexas.arlut.ciads.revdb.dao.DaoFactory;
import edu.utexas.arlut.ciads.revdb.dao.hsqldb.HsqldbDaoFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Slf4j
public class App {
    public static void main(String[] args) throws IOException {
        log.info("Hello!");


        InputStream in = ClassLoader.getSystemResourceAsStream("database.properties");
        Properties prop = new Properties();
        prop.load(in);
//        DaoFactory df = new HsqldbDaoFactory()


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
}
