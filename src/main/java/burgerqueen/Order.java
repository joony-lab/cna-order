package burgerqueen;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long branchId;
    private String sauceId;
    private Integer qty;
    private Integer price;
    private Long branchId;
    private String sauceId;
    private Integer qty;
    private Integer price;

    @PrePersist
    public void onPrePersist(){
        Ordered ordered = new Ordered();
        BeanUtils.copyProperties(this, ordered);
        ordered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        burgerqueen.external.Payment payment = new burgerqueen.external.Payment();
        // mappings goes here
        OrderApplication.applicationContext.getBean(burgerqueen.external.PaymentService.class)
            .approval(payment);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
    public String getSauceId() {
        return sauceId;
    }

    public void setSauceId(String sauceId) {
        this.sauceId = sauceId;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
    public String getSauceId() {
        return sauceId;
    }

    public void setSauceId(String sauceId) {
        this.sauceId = sauceId;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }




}