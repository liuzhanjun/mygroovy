import utils.Sqlutils

class Test {

    public static void main(String[] args) {
        Sqlutils test=new Sqlutils();
        test.connDb("bank");

        Accounts accounts1=new Accounts();
        def class_pro=[]
       accounts1.properties.each {
           key,value->
               class_pro<<key
       }
        class_pro.each {
            println it
        }



    }

    static class Student implements GroovyInterceptable {

        @Override
        Object invokeMethod(String name, Object args) {
            return super.invokeMethod(name, args)
        }
    }


}
