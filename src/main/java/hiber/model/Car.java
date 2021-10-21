package hiber.model;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private Integer series;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "car")
    public User user;

    public User getUser(){
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
