package UserScreen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User_Details {

    private final StringProperty id;
    private final StringProperty Username;
    private final StringProperty Firstname;
    private final StringProperty Lastname;
    private final StringProperty Sex;
    private final StringProperty Password;
    private final StringProperty Phone;
    private final StringProperty Email;
    private final StringProperty Color;

    public User_Details(String id,String Username, String Firstname, String Lastname,String Sex,String Password, String Phone, String Email,String Color)
    {
        this.id = new SimpleStringProperty(id);
        this.Username =  new SimpleStringProperty(Username);
        this.Firstname =  new SimpleStringProperty(Firstname);
        this.Lastname =  new SimpleStringProperty(Lastname);
        this.Sex =  new SimpleStringProperty(Sex);
        this.Password =  new SimpleStringProperty(Password);
        this.Phone =  new SimpleStringProperty(Phone);
        this.Email =  new SimpleStringProperty(Email);
        this.Color =  new SimpleStringProperty(Color);
    }
    //getters
    public String getid()
    {
        return id.get();
    }
    public String getUsername()
    {
        return Username.get();
    }
    public String getFirstname()
    {
        return Firstname.get();
    }
    public String getLastname()
    {
        return Lastname.get();
    }
    public String getSex()
    {
        return Sex.get();
    }
    public String getPassword()
    {
        return Password.get();
    }
    public String getPhone()
    {
        return Phone.get();
    }
    public String getEmail()
    {
        return Email.get();
    }
    public String getColor()
    {
        return Color.get();
    }

    //setters
    public void setid(String value)
    {
        id.set(value);
    }
    public void setUsername(String value)
    {
        Username.set(value);
    }
    public void setFirstname(String value)
    {
        Firstname.set(value);
    }
    public void setLastname(String value)
    {
        Lastname.set(value);
    }
    public void setSex(String value)
    {
        Sex.set(value);
    }
    public void setPassword(String value)
    {
        Password.set(value);
    }
    public void setPhone(String value)
    {
        Phone.set(value);
    }
    public void setEmail(String value)
    {
        Email.set(value);
    }
    public void setColor(String value)
    {
        Color.set(value);
    }




    public StringProperty idProperty()
    {
        return id;
    }
    public StringProperty UsernameProperty()
    {
        return Username;
    }
    public StringProperty FirstnameProperty()
    {
        return Firstname;
    }
    public StringProperty LastnameProperty()
    {
        return Lastname;
    }
    public StringProperty SexProperty()
    {
        return Sex;
    }
    public StringProperty PasswordProperty()
    {
        return Password;
    }
    public StringProperty PhoneProperty()
    {
        return Phone;
    }
    public StringProperty EmailProperty()
    {
        return Email;
    }
    public StringProperty ColorProperty()
    {
        return Color;
    }
}
