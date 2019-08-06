import com.hai.yun.utils.FieldConstraint
import com.hai.yun.utils.FieldType
import com.hai.yun.utils.TableField
import com.hai.yun.utils.TableModel

class Accounts implements TableModel {

    @TableField
    @FieldType(value = "Integer")
    @FieldConstraint(value = ["primary key"])
    def _id

    @TableField
    @FieldType(value = "Integer")
    @FieldConstraint(value = [",FOREIGN KEY Accounts(bank_id) REFERENCES Banks(_id)"])
    def bank_id;
    @TableField
    @FieldType(value = "varchar(10)")
    @FieldConstraint(value = ["not null"])
    def number_;
    @TableField
    @FieldType(value = "integer(10)")
    def balance_;


    @Override
    public String toString() {
        return "Accounts{" +
                "_id=" + _id +
                ", bank_id=" + bank_id +
                ", number_=" + number_ +
                ", balance_=" + balance_ +
                '}';
    }
}
