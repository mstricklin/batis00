package edu.utexas.arlut.ciads.revdb.main;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

@Slf4j
public class FooService {
    @Inject
    FooMapper fooMapper;

//    @Inject
//    FooService(final SqlSession ss) {
//        this.ss = ss;
//        fooMapper = ss.getMapper(FooMapper.class);
//    }

    public Foo select(int id) {
        return fooMapper.select(id);
    }

    public void insert(Foo f) {
        fooMapper.insert(f);
    }

    public List<Foo> list() {
        return fooMapper.list();
    }

    public void _expire(Foo f) {
        fooMapper._expire(f);
    }

    public void _update(Foo f) {
        fooMapper._update(f);
    }
    @Transactional
    public void update(Foo f) {
        _expire(f);
        _update(f);
    }
}
