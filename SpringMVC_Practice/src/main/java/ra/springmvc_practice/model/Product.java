package ra.springmvc_practice.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Product {
    @NotBlank(message = "Không để trống mã sản phẩm")
    private String productId;
    @Size(min = 10, max = 100, message = "Tên sản phẩm từ 10-100 ký tự")
    private String productName;
    @Min(value = 0, message = "Giá sản phẩm có giá trị lớn hơn hoặc bằng 0")
    private float price;
    private String title;
    private int catalogId;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, int catalogId, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public @NotBlank(message = "Không để trống mã sản phẩm") String getProductId() {
        return productId;
    }

    public void setProductId(@NotBlank(message = "Không để trống mã sản phẩm") String productId) {
        this.productId = productId;
    }

    public @Size(min = 10, max = 100, message = "Tên sản phẩm từ 10-100 ký tự") String getProductName() {
        return productName;
    }

    public void setProductName(@Size(min = 10, max = 100, message = "Tên sản phẩm từ 10-100 ký tự") String productName) {
        this.productName = productName;
    }

    @Min(value = 0, message = "Giá sản phẩm có giá trị lớn hơn hoặc bằng 0")
    public float getPrice() {
        return price;
    }

    public void setPrice(@Min(value = 0, message = "Giá sản phẩm có giá trị lớn hơn hoặc bằng 0") float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
