package id.arip.one;

import java.io.Serializable;

/**
 * Created by Arip Hidayat on 10/29/2018.
 */
public class TestObj implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long Id;
    private String name;
    private String address;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
