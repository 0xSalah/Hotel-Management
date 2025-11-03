public abstract class Rooms {
    private int  roomNumber;
    private boolean isAvailable;

    public Rooms(int _roomNumber, boolean _isAvailable){
        this.roomNumber = _roomNumber;
        this.isAvailable = _isAvailable;
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

class suiteRooms extends Rooms{
    private static double price;

    public suiteRooms(int _roomNumber, boolean _isAvailable, double _price){
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
