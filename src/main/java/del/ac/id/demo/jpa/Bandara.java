package del.ac.id.demo.jpa;


import javax.persistence.*;

@Entity
@Table(name = "t_bandara")
public class Bandara {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idbandara")
    private Long idbandara;
    @Column(name = "location")
    private String location;

    public Bandara() {
    }
    public Bandara(Long idbandara, String location) {
        this.idbandara = idbandara;
        this.location = location;
    }

    public Long getIdbandara() {
        return idbandara;
    }

    public void setIdbandara(Long idbandara) {
        this.idbandara = idbandara;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

