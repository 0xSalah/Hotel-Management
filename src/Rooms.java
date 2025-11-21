public abstract class Rooms {
    private int  roomNumber;
    private boolean isAvailable;
    private String customerName;
    private String customerPhone;


    public Rooms(int _roomNumber, boolean _isAvailable){
        this.roomNumber = _roomNumber;
        this.isAvailable = _isAvailable;
        this.customerName = null;
        this.customerPhone = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean _available) {
        this.isAvailable = _available;
    }

    public String getCustomerName(){
        return customerName;
    }

     public String getCustomerPhone(){
        return customerPhone;
    }

    public void setCustomerName(String name) {
        customerName = name;
    }

    public void setCustomerPhone(String numberPhone) {
        customerPhone = numberPhone;
    }

    public abstract double getPrice();
}

class StandardRooms extends Rooms{
    private static double price;

    public StandardRooms(int _roomNumber, boolean _isAvailable, double _price){
        super(_roomNumber,_isAvailable);
        price = _price;
    }

    @Override
    public double getPrice(){
        return price;
    }

    public static void setPrice(double _newPrice){
        price = _newPrice;
    }
}

class SuiteRooms extends Rooms{
    private static double price;

    public SuiteRooms(int _roomNumber, boolean _isAvailable, double _price){
        super(_roomNumber,_isAvailable);
        price = _price;
    }
    @Override
    public double getPrice(){
        return price;
    }

    public void setPrice(double _newPrice){
        price = _newPrice;
    }
}
