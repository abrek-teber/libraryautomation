package UserScreen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TakenBooks {
    private final StringProperty user_id;
    private final StringProperty username;
    private final StringProperty book_id;
    private final StringProperty bookname;

    public TakenBooks(String user_id,String username,String book_id,String bookname)
    {
        this.user_id = new SimpleStringProperty(user_id);
        this.username = new SimpleStringProperty(username);
        this.book_id= new SimpleStringProperty(book_id);
        this.bookname = new SimpleStringProperty(bookname);
    }
    public String getuser_id()
    {
        return user_id.get();
    }
    public String getusername()
    {
        return username.get();
    }
    public String getbook_id()
    {
        return book_id.get();
    }
    public String getbookname()
    {
        return bookname.get();
    }

    public void setuser_id(String value)
    {
        user_id.set(value);
    }
    public void setusername(String value)
    {
        username.set(value);
    }
    public void setbook_id(String value)
    {
        book_id.set(value);
    }
    public void setbookname(String value)
    {
        bookname.set(value);
    }



    public StringProperty user_idProperty()
    {
        return user_id;
    }
    public StringProperty usernameProperty()
    {
        return username;
    }
    public StringProperty book_idProperty()
    {
        return book_id;
    }
    public StringProperty booknameProperty()
    {
        return bookname;
    }









}
