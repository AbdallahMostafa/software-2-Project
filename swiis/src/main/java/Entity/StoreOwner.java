package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StoreOwner {

    private String name,userName,passWord,email;
    @Id
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public StoreOwner(String name, String userName, String passWord, String email,String type) {
        //super();
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.type = type;
    }

    public StoreOwner() {
        this.email = "";
        this.name = "";
        this.passWord = "";
        this.userName ="";
        this.type = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String type;



}
