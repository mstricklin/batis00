package edu.utexas.arlut.ciads.revdb.mappers;


import java.util.List;

import edu.utexas.arlut.ciads.revdb.DTO.Foo;

public interface FooMapper {
    Foo select(int id);
    void insert(Foo f);
    List<Foo> list();

    void _expire(Foo f);
    void _update(Foo f);
}