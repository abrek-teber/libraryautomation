package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Authors {
    private final StringProperty Authorid;
    private final StringProperty Authorname;

    public Authors(String Authorid, String Authorname) {
        this.Authorid = new SimpleStringProperty(Authorid);
        this.Authorname = new SimpleStringProperty(Authorname);

    }

    public String getAuthorid() {
        return Authorid.get();
    }

    public String getAuthorname() {
        return Authorname.get();
    }

    public void setAuthorid(String value) {
        Authorid.set(value);
    }

    public void setAuthorname(String value) {
        Authorname.set(value);
    }

    public StringProperty AuthoridProperty() {
        return Authorid;
    }

    public StringProperty AuthornameProperty() {
        return Authorname;
    }
}
