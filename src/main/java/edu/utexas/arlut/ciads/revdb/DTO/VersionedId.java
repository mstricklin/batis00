package edu.utexas.arlut.ciads.revdb.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public abstract class VersionedId {
    private int id;
    private int branch;
    private int vstart;
    private int vend;
}
