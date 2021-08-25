Feature: Java Classes can be turned into DiffTrees
We expect that the following changes are recognized:

Scenario: A change in class title is recognized.
Given an original:
"""
public class Foo {
}
"""
And a modified:
"""
public class Bar {
}
"""
When a DiffTree is created
Then node ROOT has label CLASS
And ROOT has a child, CAM, at position 0
And ROOT has two children, OLD_NAME and NEW_NAME, at position 1, where OLD_NAME is of type DELETE and NEW_NAME is of type CREATE
And OLD_NAME has label IDENTIFIER
And OLD_NAME has value Foo
And NEW_NAME has label IDENTIFIER
And NEW_NAME has value Bar