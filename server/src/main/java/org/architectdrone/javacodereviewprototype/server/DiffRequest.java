package org.architectdrone.javacodereviewprototype.server;

import lombok.Data;

@Data
public class DiffRequest {
    AST original;
    AST modified;
}
