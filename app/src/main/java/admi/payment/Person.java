package admi.payment;

/**
 * Created by Admin on 6/16/2016.
 */
public class Person {
    private String name;
    private String country;
    private String twitter;

    public Person(String name, String country, String twitter) {
        this.name = name;
        this.country = country;
        this.twitter = twitter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
