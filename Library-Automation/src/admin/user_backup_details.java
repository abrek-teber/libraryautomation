package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class user_backup_details {

    private final StringProperty username_backup;
    private final StringProperty firstname_backup;
    private final StringProperty lastname_backup;
    private final StringProperty password_backup;
    private final StringProperty phone_backup;
    private final StringProperty email_backup;
    private final StringProperty color_backup;


    public user_backup_details(String username_backup,String firstname_backup, String lastname_backup, String password_backup,String phone_backup,String email_backup, String color_backup)
    {
        this.username_backup = new SimpleStringProperty(username_backup);
        this.firstname_backup =  new SimpleStringProperty(firstname_backup);
        this.lastname_backup =  new SimpleStringProperty(lastname_backup);
        this.password_backup =  new SimpleStringProperty(password_backup);
        this.phone_backup =  new SimpleStringProperty(phone_backup);
        this.email_backup =  new SimpleStringProperty(email_backup);
        this.color_backup =  new SimpleStringProperty(color_backup);

    }
    //getters
    public String getusername_backup()
    {
        return username_backup.get();
    }
    public String getfirstname_backup()
    {
        return firstname_backup.get();
    }
    public String getlastname_backup()
    {
        return lastname_backup.get();
    }
    public String getpassword_backup()
    {
        return password_backup.get();
    }
    public String getphone_backup()
    {
        return phone_backup.get();
    }
    public String getemail_backup()
    {
        return email_backup.get();
    }
    public String getcolor_backup()
    {
        return color_backup.get();
    }


    //setters
    public void setusername_backup(String value)
    {
        username_backup.set(value);
    }
    public void setfirstname_backup(String value)
    {
        firstname_backup.set(value);
    }
    public void setlastname_backup(String value)
    {
        lastname_backup.set(value);
    }
    public void setpassword_backup(String value)
    {
        password_backup.set(value);
    }
    public void setphone_backup(String value)
    {
        phone_backup.set(value);
    }
    public void setemail_backup(String value)
    {
        email_backup.set(value);
    }
    public void setcolor_backup(String value)
    {
        color_backup.set(value);
    }





    public StringProperty username_backupProperty()
    {
        return username_backup;
    }
    public StringProperty firstname_backupProperty()
    {
        return firstname_backup;
    }
    public StringProperty lastname_backupProperty()
    {
        return lastname_backup;
    }
    public StringProperty password_backupProperty()
    {
        return password_backup;
    }
    public StringProperty phone_backupProperty()
    {
        return phone_backup;
    }
    public StringProperty email_backupProperty()
    {
        return email_backup;
    }
    public StringProperty color_backupProperty()
    {
        return color_backup;
    }

}
