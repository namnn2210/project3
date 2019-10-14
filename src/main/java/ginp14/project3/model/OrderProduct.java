package ginp14.project3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_product")
public class OrderProduct implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "size")
    private String size;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, int quantity, String size) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.size = size;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
