package lk.ijse.cinemax.dto;

public class SignUpDto {

    private String userId;
    private String fristName;
    private String lastName;
    private String userName;
    private String Password;

    public SignUpDto() {
    }

    public SignUpDto(String userId, String fristName, String lastName, String userName, String password) {
        this.userId = userId;
        this.fristName = fristName;
        this.lastName = lastName;
        this.userName = userName;
        this.Password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
