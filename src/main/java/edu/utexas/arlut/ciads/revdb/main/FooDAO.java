package edu.utexas.arlut.ciads.revdb.main;

import java.util.List;

import edu.utexas.arlut.ciads.revdb.DTO.Foo;

interface FooDAO {
    Foo select(int id);

    void insert(Foo f);

    List<Foo> list();
    void _expire(Foo f);
    void _update(Foo f);
    void update(Foo f);
}
