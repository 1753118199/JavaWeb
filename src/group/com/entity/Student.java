package group.com.entity;

public class Student {
    private int sId;
    private String sName;
    private String sex;
    private String sClass;
    private int deleted;

    public Student(int sId, String sName, String sex, String sClass, int deleted) {
        this.sId = sId;
        this.sName = sName;
        this.sex = sex;
        this.sClass = sClass;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sex='" + sex + '\'' +
                ", sClass='" + sClass + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public int getsId() {
        return sId;
    }

    public Student setsId(int sId) {
        this.sId = sId;
        return this;
    }

    public String getsName() {
        return sName;
    }

    public Student setsName(String sName) {
        this.sName = sName;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Student setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getsClass() {
        return sClass;
    }

    public Student setsClass(String sClass) {
        this.sClass = sClass;
        return this;
    }

    public int getDeleted() {
        return deleted;
    }

    public Student setDeleted(int deleted) {
        this.deleted = deleted;
        return this;
    }
}
