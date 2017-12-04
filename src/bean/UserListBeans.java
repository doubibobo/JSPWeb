package bean;

/**
 * Created by zhuch on 2017/12/4.
 */
public class UserListBeans {
    public String userid;
    public String username;
    public String sex;

    public String qq;
    public String tel;
    public String province;

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public String getQq() {
        return qq;
    }

    public String getTel() {
        return tel;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public String getSex() {
        return sex;
    }

    public String getUserid() {
        return userid;
    }
}
