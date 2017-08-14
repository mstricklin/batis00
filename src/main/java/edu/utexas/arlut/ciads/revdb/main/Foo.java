package edu.utexas.arlut.ciads.revdb.main;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class Foo extends VersionId {
    private String s0;
    private String s1;
    private String s2;

}
