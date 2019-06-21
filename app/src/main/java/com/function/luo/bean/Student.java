package com.function.luo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by luo on 2019/6/20.
 */
@Entity(nameInDb = "STUDENT")
public class Student extends DbBean{
    @Id(autoincrement = true)
    Long id;
    /**
     * 学号
     */
    @Property(nameInDb = "studentNo")
    int studentNo;
    /**
     * 年龄
     */
    @Property(nameInDb = "age")
    int age;
    /**
     * 手机号
     */
    @Property(nameInDb = "telPhone")
    String telPhone;
    /**
     * 性别
     */
    @Property(nameInDb = "sex")
    String sex;
    /**
     * 姓名
     */
    @Property(nameInDb = "name")
    String name;
    /**
     * 家庭住址
     */
    @Property(nameInDb = "address")
    String address;
    /**
     * 学校名字
     */
    @Property(nameInDb = "schoolName")
    String schoolName;
    /**
     * 几年级
     */
    @Property(nameInDb = "grade")
    String grade;
    @Generated(hash = 1071002287)
    public Student(Long id, int studentNo, int age, String telPhone, String sex,
            String name, String address, String schoolName, String grade) {
        this.id = id;
        this.studentNo = studentNo;
        this.age = age;
        this.telPhone = telPhone;
        this.sex = sex;
        this.name = name;
        this.address = address;
        this.schoolName = schoolName;
        this.grade = grade;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getStudentNo() {
        return this.studentNo;
    }
    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getTelPhone() {
        return this.telPhone;
    }
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSchoolName() {
        return this.schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public String getGrade() {
        return this.grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
  

}
