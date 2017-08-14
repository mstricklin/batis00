package edu.utexas.arlut.ciads.revdb.main;


import java.util.List;

public interface FooMapper {
    Foo select(int id);
    void insert(Foo f);
    List<Foo> list();

    void _expire(Foo f);
    void _update(Foo f);
}