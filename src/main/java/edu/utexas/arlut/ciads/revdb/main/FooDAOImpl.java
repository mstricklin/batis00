package edu.utexas.arlut.ciads.revdb.main;

import edu.utexas.arlut.ciads.revdb.DTO.Foo;
import edu.utexas.arlut.ciads.revdb.mappers.FooMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FooDAOImpl implements FooDAO {
    FooDAOImpl(SqlSession sess) {
        this.sess = sess;
        mapper = sess.getMapper(FooMapper.class);
    }
    private final SqlSession sess;
    private final FooMapper mapper;

    @Override
    public Foo select(int id) {
        return mapper.select(id);
    }

    @Override
    public void insert(Foo f) {
        mapper.insert(f);
    }

    @Override
    public List<Foo> list() {
        return mapper.list();
    }

    @Override
    public void _expire(Foo f) {
        mapper._expire(f);
    }

    @Override
    public void _update(Foo f) {
        mapper._update(f);
    }

    @Override
    public void update(Foo f) {
        mapper._expire(f);
        mapper._update(f);
    }
}
