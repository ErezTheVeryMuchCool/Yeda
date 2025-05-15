public class CarInfo {


   private String id;
   private boolean privateCar;
   private int speed;


   public CarInfo(String id, boolean privateCar, int speed) {
       this.id = id;
       this.privateCar = privateCar;
       this.speed = speed;
   }


   public int getSpeed() {
       return speed;
   }


   public String getId() {
       return id;
   }
   public boolean getPrivateCar() {
       return privateCar;
   }


   public void setId(String id) {
       this.id = id;
   }


   public void setPrivateCar(boolean privateCar) {
       this.privateCar = privateCar;
   }


   public void setSpeed(int speed) {
       this.speed = speed;
   }


   @Override
   public String toString() {
       return "CarInfo{" +
               "id='" + id + '\'' +
               ", privateCar=" + privateCar +
               ", speed=" + speed +
               '}';
   }


   public boolean illegal(int maxSpeed) {
       if (this.speed > maxSpeed) {
           return true;
       }
       return false;
   }




}
