public class CameraInfo {


   private int city;
   private int maxSpeed;
   private CarInfo[] cars;


   public CameraInfo(int city, int maxSpeed, CarInfo[] CarInfo) {
       this.city = city;
       this.maxSpeed = maxSpeed;
       this.cars = cars;
   }


   public CarInfo[] getCars() {
       return cars;
   }


   public int getCity() {
       return city;
   }


   public int getMaxSpeed() {
       return maxSpeed;
   }


   public void setCars(CarInfo[] cars) {
       this.cars = cars;
   }


   public void setCity(int city) {
       this.city = city;
   }


   public void setMaxSpeed(int maxSpeed) {
       this.maxSpeed = maxSpeed;
   }


   public boolean allGood() {
       for (int i = 0; i < this.cars.length; i++) {
           if (cars[i].getSpeed() > maxSpeed) {
               return false;
           }
       }
       return true;
   }




}
