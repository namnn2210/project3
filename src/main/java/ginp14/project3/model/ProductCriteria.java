package ginp14.project3.model;

public class ProductCriteria {
    private int id;
    private String size;
    private int quantity;

    public ProductCriteria() {
    }

    public ProductCriteria(int id, String size, int quantity) {
        this.id = id;
        this.size = size;
        this.quantity = quantity;
    }

    public ProductCriteria(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public ProductCriteria(int id, String size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
