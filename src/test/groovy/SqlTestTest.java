import com.hai.yun.utils.TableUtils;
import groovy.transform.ASTTest;
import groovy.util.GroovyTestCase;
import org.junit.Test;
import utils.Sqlutils;

public class SqlTestTest{

    @Test
    public void createDB() {
        Sqlutils test = new Sqlutils();
        test.connDb("myDb");


        Banks banks=new Banks();
//        test.createTable(new Accounts());
        banks.set_id("0");
        banks.setName("RBS");

        test.insterInto(banks);


    }
}