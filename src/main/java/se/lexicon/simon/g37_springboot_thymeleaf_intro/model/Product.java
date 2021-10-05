package se.lexicon.simon.g37_springboot_thymeleaf_intro.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private String id;
    private String ProductName;
    private BigDecimal price;

    public Product(String id, String productName, BigDecimal price) {
        this.id = id;
        ProductName = productName;
        this.price = price;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", price=" + price +
                '}';
    }
}
