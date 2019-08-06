package com.hai.yun.utils;

import java.lang.reflect.Field;

public class TableUtils {

    public static String getCreateSql(TableModel model) {
        String foreignKey=null;
        StringBuffer sql = new StringBuffer("create table ");
        String tableName = null;
        Class classz = model.getClass();
        try {

            //获得表名
            tableName = classz.getSimpleName();
            sql.append(tableName + " (");
            //获得所有属性
            Field[] fields = classz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                StringBuffer tempbf=new StringBuffer();
                //查看是否有TableField注解
                boolean tablefile = fields[i].isAnnotationPresent(TableField.class);
//                这个判断表示该属性是否是表结构的字段
                if (tablefile) {
                    //说明这个属性是字段
                    //获得这个字段的名称 类型 约束
                    boolean fieldType = fields[i].isAnnotationPresent(FieldType.class);
                    if (fieldType) {
                        FieldType mode = fields[i].getAnnotation(FieldType.class);
                        //获得字段名称
                        String fieldName = fields[i].getName();
                        //获得字段类型
                        String value = mode.value();
                        //获得字段约束
                        boolean isConstraint = fields[i].isAnnotationPresent(FieldConstraint.class);
                        if (!sql.substring(sql.length() - 1, sql.length()).equals("(")) {
                            tempbf.append(",");
                        }
                        tempbf.append(fieldName + " " + value);
                        if (isConstraint) {
                            FieldConstraint constraint = fields[i].getAnnotation(FieldConstraint.class);
                            String[] values = constraint.value();
                            for (int j = 0; j < values.length; j++) {
                                tempbf.append(" " + values[j]);
                            }
                        }

                    } else {
                        throw new Throwable(fields[i].getName() + "字段类型不明确,请在该字段上加上注解@FieldType");
                    }
                }



                sql.append(tempbf.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        sql.append(")");
        return sql.toString();
    }
}
