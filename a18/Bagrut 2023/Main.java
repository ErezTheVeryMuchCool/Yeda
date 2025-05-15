public class Main {
   public static int legalCities(CameraInfo[] cameras) {
       int good = 0;
       boolean[] goods = new boolean[100];
       for (int i = 0; i < cameras.length; i++) {
           if (!cameras[i].allGood( && !goods[i])) {
               goods[cameras[i].getCity()] = true;
           }
       }


       for (int i = 0; i < 100; i++) {
           if (!goods[i]) {
               good++;
           }
       }
       return good;
   }


}
