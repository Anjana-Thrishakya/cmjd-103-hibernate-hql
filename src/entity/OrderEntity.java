package entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderEntity {  

    @Id
    @Column(name = "OrderID", length = 6, nullable = false)
    private String id;

    @Column(name = "OrderDate", columnDefinition = "date")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CustID", nullable = false)
    private CustomerEntity customerEntity;
}
