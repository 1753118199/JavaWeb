package group.com.entity;

public class Course {
    private int cId;
    private String cName;
    private float credit;
    private int deleted;

    public Course(int cId, String cName, float credit, int deleted) {
        this.cId = cId;
        this.cName = cName;
        this.credit = credit;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", credit=" + credit +
                ", deleted=" + deleted +
                '}';
    }

    public int getcId() {
        return cId;
    }

    public Course setcId(int cId) {
        this.cId = cId;
        return this;
    }

    public String getcName() {
        return cName;
    }

    public Course setcName(String cName) {
        this.cName = cName;
        return this;
    }

    public float getCredit() {
        return credit;
    }

    public Course setCredit(float credit) {
        this.credit = credit;
        return this;
    }

    public int getDeleted() {
        return deleted;
    }

    public Course setDeleted(int deleted) {
        this.deleted = deleted;
        return this;
    }
}

