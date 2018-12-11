package e59070146.kmitl.ac.th.mobilefinal.tools;

public class Account {

    private String userId, userName, password;
    private int age;

    public static final String DATABASE_NAME = "app.db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE = "accountTable";

    public class Column {
        public static final String USER_ID = "userId";
        public static final String USER_NAME = "userName";
        public static final String PASSWORD = "password";
        public static final String AGE = "age";
    }

    public Account(){

    }

    public Account(String userId, String userName, String password, int age) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
