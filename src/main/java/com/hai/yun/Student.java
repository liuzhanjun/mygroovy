package com.hai.yun;

import com.hai.yun.utils.FieldConstraint;
import com.hai.yun.utils.FieldType;
import com.hai.yun.utils.TableField;
import com.hai.yun.utils.TableModel;

/**
 * Created by 刘展俊 on 2017/5/22.
 */

public class Student implements TableModel {
    @TableField
    @FieldType(value ="Integer")
    @FieldConstraint(value = {"primary key"})
    public Integer _s_id;
    @TableField
    @FieldType(value ="varchar(10)")
    @FieldConstraint(value = {"not null"})
    public String name;
    @TableField
    @FieldType(value ="Integer")
    public Integer age;

    public Integer get_s_id() {
        return _s_id;
    }

    public void set_s_id(Integer _s_id) {
        this._s_id = _s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {

    }

    public Student(Integer _s_id, String name, Integer age) {
        this._s_id = _s_id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_s_id=" + _s_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
