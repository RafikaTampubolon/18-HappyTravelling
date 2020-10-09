package del.ac.id.demo.jpa;

import javax.persistence.*;

@Entity
@Table(name = "t_booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idbooking")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "fromlocation")
    private String from;
    @Column(name = "tolocation")
    private String to;
    @Column(name = "depature")
    private String depature;
    @Column(name = "returndate")
    private String returndate;
    @Column(name = "numberpassangers")
    private int numberpassangers;

    public Booking() {
    }

    public Booking(Long id, String username, String from, String to, String depature, String returndate, int numberpassangers) {
        this.id = id;
        this.username = username;
        this.from = from;
        this.to = to;
        this.depature = depature;
        this.returndate = returndate;
        this.numberpassangers = numberpassangers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepature() {
        return depature;
    }

    public void setDepature(String depature) {
        this.depature = depature;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public int getNumberpassangers() {
        return numberpassangers;
    }

    public void setNumberpassangers(int numberpassangers) {
        this.numberpassangers = numberpassangers;
    }
}

