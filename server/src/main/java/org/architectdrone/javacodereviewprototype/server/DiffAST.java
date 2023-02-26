package org.architectdrone.javacodereviewprototype.server;

import lombok.Data;

import java.util.List;

@Data
public class DiffAST {
    String value;
    String label;
    List<DiffAST> children;
    String referenceType;
    String oldValue;
    int moveId;
}
