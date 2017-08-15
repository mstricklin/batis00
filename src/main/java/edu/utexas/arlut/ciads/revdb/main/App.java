// CLASSIFICATION NOTICE: This file is UNCLASSIFIED
package edu.utexas.arlut.ciads.revdb.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.google.inject.*;
import edu.utexas.arlut.ciads.revdb.DTO.Foo;
import edu.utexas.arlut.ciads.revdb.DTO.RuntimeContextProvider;
import edu.utexas.arlut.ciads.revdb.DTO.RuntimeContextProvider.RuntimeContext;
import edu.utexas.arlut.ciads.revdb.mappers.FooMapper;
import edu.utexas.arlut.ciads.revdb.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hsqldb.Database;
import org.mybatis.guice.XMLMyBatisModule;

import javax.sql.DataSource;

@Slf4j
public class App {
    public static void main(String[] args) throws IOException {
        log.info("Hello!");


        InputStream in = ClassLoader.getSystemResourceAsStream("database.properties");
        final Properties props = new Properties();
        props.load(in);

//        DataSourceFactory dsf = new HikariFactory(props);
//        props.put("dataSource", dsf);
//        props.load(in);
//        final Provider<DataSource> dsp = new HsqldbDataSourceProvider(props);
//        new SchemaVersionManager(dsf.getDataSource()).migrate();

//        MyBatisModule
        AbstractModule mbm = new XMLMyBatisModule() {

            @Override
            protected void initialize() {
//                setEnvironmentId("development");
//                setClassPathResource("my/path/to/mybatis-config.xml");
//                addProperties(props);

//                environmentId("development");
//                bindDataSourceProvider(dsp);
//                bindTransactionFactoryType(JdbcTransactionFactory.class);

//                addMapperClass(FooMapper.class);
                // Must bind services in the MyBatisModule for @Transactional.
//                bind(FooDAO.class).to(FooDAOImpl.class);
                bind(FooService.class);

                // need to bind any services that use @Transactional
//                bind(ServiceB.class);
//                bind(CompositeService.class);
            }

        };

        AbstractModule am = new AbstractModule() {
            @Override
            protected void configure() {
//                bind(RuntimeContext.class)
                        ;//.toProvider(RuntimeContextProvider.class);
                bind(RuntimeContextProvider.class);
                bind(TThread.class);
                bind(RC.class).in(Singleton.class);
            }
        };

        Injector injector = Guice.createInjector(mbm, am);

        for (Map.Entry<Key<?>, Binding<?>> e : injector.getAllBindings().entrySet())
            log.info("binding {} => {}", e.getKey(), e.getValue());
//        SqlSessionManager
//        SqlSession
//        SqlSessionManagerProvider


        FooService fs = injector.getInstance(FooService.class);
        for (Foo f : fs.list())
            log.info("f: {}", f);
        log.info("");
//        Foo f1 = fs.select(1);
//        log.info("f1: {}", f1);
//        fs.update(f1);
        log.info("");
        for (Foo f : fs.list())
            log.info("f: {}", f);

        FooMapper fm = injector.getInstance(FooMapper.class);
        SqlSessionFactory ssf = injector.getInstance(SqlSessionFactory.class);
        log.info("SqlSessionFactory {}", ssf);

//        RuntimeContextProvider rcp = injector.getInstance(RuntimeContextProvider.class);
//        log.info("RuntimeContextProvider {}", rcp);
////        rcp.set(1, 1);
//        RuntimeContext rc = rcp.get();
//        log.info("RuntimeContext {}", rc);
//        rc.foo();

//        Provider<RC> rcp =


        TThread tt = injector.getInstance(TThread.class);
        Thread t = new Thread(tt);
        t.start();






//        SqlSessionFactory ssf;
        DataSource ds = ssf.getConfiguration().getEnvironment().getDataSource();
        log.info("DataSource {}", ds);
//        ((HikariDataSource) ds).close();


//        FooDAO fdao = injector.getInstance(FooDAOImpl.class);
//        Foo f0a = fdao.select(1);
//        log.info("f0 {}", f0a);
//
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        log.info("session factory {}", sqlSessionFactory);
////        sqlSessionFactory.getConfiguration().addMapper(FooMapper.class);
//
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//
//            FooDAOImpl fd = new FooDAOImpl(session);
//
//            log.info(" == list Foos ==");
//            for (Foo f: fd.list())
//                log.info("f: {}", f);
//            log.info("");
//            Foo f0 = fd.select(1);
//            log.info("Foo0 {}", f0);
//
//            Foo f1 = new Foo();
//            f1.setId(6);
//            f1.setBranch(3);
//            f1.setVstart(1);
//            f1.setS0("aaa0");
//            f1.setS1("aaa1");
//            f1.setS2("aaa2");
//
//            fd.insert(f1);
//            log.info("Foo1 {}", f1);
//            f1 = fd.select(6);
//            log.info("Foo1 {}", f1);
//
//            log.info(" == list Foos ==");
//            for (Foo f: fd.list())
//                log.info("f: {}", f);
//
//            fd.update(f1);
//
//            log.info(" == list Foos ==");
//            for (Foo f: fd.list())
//                log.info("f: {}", f);
//
//            session.commit();
//        } finally {
//            log.info("closing");
//            org.hsqldb.DatabaseManager.closeDatabases(0);
//        }

        org.hsqldb.DatabaseManager.closeDatabases(Database.CLOSEMODE_NORMAL);

    }
}
