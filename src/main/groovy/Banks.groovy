import com.hai.yun.utils.FieldConstraint
import com.hai.yun.utils.FieldType
import com.hai.yun.utils.TableField
import com.hai.yun.utils.TableModel

class Banks implements TableModel{

    @TableField
    @FieldType(value = "Integer")
    @FieldConstraint(value = ["primary key"])
    def _id;
    @TableField
    @FieldType(value = "varchar(20)")
    def name;
}
