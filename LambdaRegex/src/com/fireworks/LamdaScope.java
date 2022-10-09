package com.fireworks;

public class LamdaScope {

    public final static String stringOperations(UpperConcat uc, String s1, String s2)
    {
        return uc.upperAndConcat(s1,s2);
    }

    public static void main(String[] args)
    {
        SecondaryClass secondaryClass = new SecondaryClass();
        String s = secondaryClass.startOperation();
        System.out.println(s);

    }
}

class SecondaryClass {
    String startOperation(){

        UpperConcat uc = (s1,s2)->{
            System.out.println("The lambda expressions class is: "+getClass().getSimpleName());
            return s1.toUpperCase()+s2.toUpperCase();
        };

        /*UpperConcat uc = new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The lambda expressions class is: "+getClass().getSimpleName());
                return s1.toUpperCase()+s2.toUpperCase();
            }
        };*/
        System.out.println("Primary class name is : "+getClass().getSimpleName());
        return LamdaScope.stringOperations(uc,"String1", "String2");
    }

}

/*
* When we execute the above code we get the following output:
* Primary class name is : SecondaryClass
* The lambda expressions class is: SecondaryClass
* STRING1STRING2
*
* In the above example we can see the primary class name and the lambda expressions class name are
* both the same.
* Unlike implementing a method using an anonymous class where the class name would be displayed as ""
* , the lambda expression belongs to the Secondary class.
* This tells us that the lambda expression is not treated as a class but as a nested code block and
* has the same scope as a nested block.
* We will see in the upcoming examples that lambda expressions as a matter of fact behave like nested
* code blocks.
* */