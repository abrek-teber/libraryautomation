package UserScreen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class bookdetails {
    private final StringProperty Bookid;
    private final StringProperty Bookname;
    private final StringProperty Bookauthor;
    private final StringProperty Booktype;

    public bookdetails(String Bookid,String Bookname,String Bookauthor,String Booktype)
    {
        this.Bookid = new SimpleStringProperty(Bookid);
        this.Bookname = new SimpleStringProperty(Bookname);
        this.Bookauthor= new SimpleStringProperty(Bookauthor);
        this.Booktype = new SimpleStringProperty(Booktype);
    }
    public String getBookid()
    {
        return Bookid.get();
    }
    public String getBookname()
    {
        return Bookname.get();
    }
    public String getBookauthor()
    {
        return Bookauthor.get();
    }
    public String getBookType()
    {
        return Booktype.get();
    }

    public void setBookid(String value)
    {
        Bookid.set(value);
    }
    public void setBookname(String value)
    {
         Bookname.set(value);
    }
    public void setBookauthor(String value)
    {
        Bookauthor.set(value);
    }
    public void setBooktype(String value)
    {
        Booktype.set(value);
    }



    public StringProperty BookidProperty()
    {
        return Bookid;
    }
    public StringProperty BooknameProperty()
    {
        return Bookname;
    }
    public StringProperty BookauthorProperty()
    {
        return Bookauthor;
    }
    public StringProperty BooktypeProperty()
    {
        return Booktype;
    }









}
