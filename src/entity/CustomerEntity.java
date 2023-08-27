package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerEntity {

    @Id
    @Column(name = "CustID", length = 6, nullable = false)
    private String id;

    @Column(name = "CustTitle", length = 5)
    private String title;

    @Column(name = "CustName", length = 30, nullable = false)
    private String name;

    @Column(name = "DOB", columnDefinition = "date")
    private Date dob;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "CustAddress", length = 30)
    private String address;

    @Column(name = "City", length = 20)
    private String city;

    @Column(name = "Province", length = 20)
    private String province;

    @Column(name = "PostalCode", length = 9)
    private String zipCode;

    @ToString.Exclude
    @OneToMany(mappedBy = "customerEntity", targetEntity = OrderEntity.class)
    private List<OrderEntity> orderEntities;
}
