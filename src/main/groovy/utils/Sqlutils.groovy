package utils

import com.hai.yun.utils.TableUtils
import com.hai.yun.utils.bean.Structure
import groovy.sql.Sql

class Sqlutils {
    def sql_eve;

    def name;

    def connDb(db) {
        def dbDriver = "com.mysql.cj.jdbc.Driver";
        def host = "jdbc:mysql://localhost:3306/${db}?useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true"
        def user = "root"
        def password = "1043261503"
        sql_eve = Sql.newInstance(host, user, password, dbDriver)

    }

    def createDB(database_name) {
        connDb("")
        return sql_eve.execute("CREATE DATABASE " + database_name)
    }

    def queryTableStructure(table_name) {

        def result = [];
        sql_eve.eachRow("desc " + table_name) {
            pa ->
                result << new Structure(mField: pa.Field, mType: pa.Type);

        };
        return result

    }

    /**
     * 创建数据表
     * @param table_name TableModel的实现类
     */
    def createTable(table_name) {
        def sqls = TableUtils.getCreateSql(table_name);
    }

//    def queryTable(){
//        sql_eve.eachRow
//    }

    def insterInto(table){
        String tname=table.getClass().getName()
        def mTable=sql_eve.dataSet(tname)
        mTable.add(_id:table._id,name:table.name);
        sql_eve.eachRow("select * from "+tname){
            pa-> println pa

        }
    }


}
