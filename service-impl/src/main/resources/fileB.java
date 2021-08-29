public class MyClass extends MyExtendingClass implements MyImplementingClass, MyOtherImplementingClass {
    public void myMethod() {
        System.out.println("Hello");
    }

    public String myOtherMethod() {
        System.out.println("Hello again", "Hello");

        Person owen = Person.builder()
                .name("Owen")
                .age(24)
                .gender(MALE)
                .build();
    }
}