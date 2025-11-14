public class HotelManag {
    private StandardRooms[] standardRooms;
    private SuiteRooms[] suiteRooms;
    private double totalEarning;

    public HotelManag(int numStandard, double standardPrice, int numSuite, double suitePrice){
        standardRooms = new StandardRooms[numStandard];
        suiteRooms = new SuiteRooms[numSuite];

        for (int i = 0; i < numStandard; i++){
            standardRooms[i] = new StandardRooms(i+1, true, standardPrice);
        }
        for (int i = 0; i < numSuite; i++){
            suiteRooms[i] = new SuiteRooms(i+1, true, suitePrice);
        }

        totalEarning = 0;
    }

    public int findAvailableStandardRoom() {
        for (int i = 0; i < standardRooms.length; i++){
            if (standardRooms[i].isAvailable() == true){
                return standardRooms[i].getRoomNumber();
            }
        }
        return -1;
    }

    public int findAvailableSuiteRoom() {
        for (int i = 0; i < suiteRooms.length; i++){
            if (suiteRooms[i].isAvailable() == true){
                return suiteRooms[i].getRoomNumber();
            }
        }
        return -1;
    }


    public boolean bookStandardRoom(String custmomerName, String phoneNumber){
        int roomNum = findAvailableStandardRoom();
        if(roomNum == -1){
            System.out.println("No rooms available");
            return false;
        }

        for (int i = 0; i < standardRooms.length; i ++){
            if (standardRooms[i].getRoomNumber() == roomNum){
                standardRooms[i].setAvailable(false);
                standardRooms[i].setCustomerName(custmomerName);
                standardRooms[i].setCustomerPhone(phoneNumber);
                totalEarning += standardRooms[i].getPrice();
                System.out.println("Room Number "+ standardRooms[i].getRoomNumber()+" has booked for the client " + custmomerName);
            }
        }
        return true;
    }

    public boolean bookSuiteRoom(String custmomerName, String phoneNumber){
        int roomNum = findAvailableSuiteRoom();
        if(roomNum == -1){
            System.out.println("No suite available");
            return false;
        }

        for (int i = 0; i < suiteRooms.length; i ++){
            if (suiteRooms[i].getRoomNumber() == roomNum){
                suiteRooms[i].setAvailable(false);
                suiteRooms[i].setCustomerName(custmomerName);
                suiteRooms[i].setCustomerPhone(phoneNumber);
                totalEarning += suiteRooms[i].getPrice();
                System.out.println("suite Number "+ suiteRooms[i].getRoomNumber()+" has booked for the client " + custmomerName);
            }
        }
        return true;
    }

    public double getTotalEarning(){
        return totalEarning;
    }

    public void showRoomStatus(int numberRoom){
        for ( int i =0; i< standardRooms.length; i++){
            if ( standardRooms[i].getRoomNumber() == numberRoom){
                System.out.println("Customer Name : "+standardRooms[i].getCustomerName()+ " Customer Phone Number : " + standardRooms[i].getCustomerPhone());
            }
        }
    }

    public void showSuiteStatus(int roomNumber){
        for ( int i =0; i< suiteRooms.length; i++){
            if ( suiteRooms[i].getRoomNumber() == roomNumber){
                System.out.println("Customer Name : "+suiteRooms[i].getCustomerName()+ " Customer Phone Number : " + suiteRooms[i].getCustomerPhone());
            }
        }
    }

    public void cancelStandardRoom(int roomNumber){
        for (int i = 0; i < standardRooms.length; i++){
            if (standardRooms[i].getRoomNumber() == roomNumber){
                if ( standardRooms[i].isAvailable() == false){
                    standardRooms[i].setAvailable(true);
                    standardRooms[i].setCustomerName(null);
                    standardRooms[i].setCustomerPhone(null);
                    System.out.println("Room number "+ roomNumber +" has been canselled");
                }else {
                    System.out.println("The room is not booked");
                }
            }else {
                System.out.println("The room does not exist");
            }
        }
    }

    public void cancelSuiteRoom(int roomNumber){
        for (int i = 0; i < suiteRooms.length; i++){
            if (suiteRooms[i].getRoomNumber() == roomNumber){
                if ( suiteRooms[i].isAvailable() == false){
                    suiteRooms[i].setAvailable(true);
                    suiteRooms[i].setCustomerName(null);
                    suiteRooms[i].setCustomerPhone(null);
                    System.out.println("Suite number "+ roomNumber +" has been canselled");
                }else {
                    System.out.println("The Suite is not booked");
                }
            }else {
                System.out.println("The Suite does not exist");
            }
        }
    }

}
