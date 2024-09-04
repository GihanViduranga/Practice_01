package ly.pt.model;

public class item {
    private String Code;
    private String ItemName;
    private int QTY;
    private String Price;

    public item() {
    }

    public item(String code, String itemName, int QTY, String price) {
        Code = code;
        ItemName = itemName;
        this.QTY = QTY;
        Price = price;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "item{" +
                "Code='" + Code + '\'' +
                ", ItemName='" + ItemName + '\'' +
                ", QTY=" + QTY +
                ", Price='" + Price + '\'' +
                '}';
    }
}
