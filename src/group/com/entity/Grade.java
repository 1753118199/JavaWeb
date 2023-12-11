package group.com.entity;

public class Grade {
    private int sId;
    private String sName;
    private int cId;
    private String cName;
    private float score;
    private int deleted;

    public Grade(int sId, String sName, int cId, String cName, float score, int deleted) {
        this.sId = sId;
        this.sName = sName;
        this.cId = cId;
        this.cName = cName;
        this.score = score;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", cId=" + cId +
                ", cName='" + cName + '\'' +
                ", score=" + score +
                ", deleted=" + deleted +
                '}';
    }

    public int getsId() {
        return sId;
    }

    public Grade setsId(int sId) {
        this.sId = sId;
        return this;
    }

    public String getsName() {
        return sName;
    }

    public Grade setsName(String sName) {
        this.sName = sName;
        return this;
    }

    public int getcId() {
        return cId;
    }

    public Grade setcId(int cId) {
        this.cId = cId;
        return this;
    }

    public String getcName() {
        return cName;
    }

    public Grade setcName(String cName) {
        this.cName = cName;
        return this;
    }

    public float getScore() {
        return score;
    }

    public Grade setScore(float score) {
        this.score = score;
        return this;
    }

    public int getDeleted() {
        return deleted;
    }

    public Grade setDeleted(int deleted) {
        this.deleted = deleted;
        return this;
    }
}
