package edu.utexas.arlut.ciads.revdb.main;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public abstract class VersionId {
    private int id;
    private int branch;
    private int vstart;
    private int vend;
}
