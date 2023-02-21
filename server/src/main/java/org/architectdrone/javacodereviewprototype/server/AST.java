package org.architectdrone.javacodereviewprototype.server;

import lombok.Data;

import java.util.List;

@Data
public class AST {
    public String value;
    public String label;
    public List<AST> children;
}
