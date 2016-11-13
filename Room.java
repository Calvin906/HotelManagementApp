public class Room {
     String[] options;
    int rID;
    String type;
    String description;
    int price;

    public Room(int rID, String type, String description, int price) {

        options = new String[]{String.valueOf(rID), type, description, String.valueOf(price)};
        this.rID = rID;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
