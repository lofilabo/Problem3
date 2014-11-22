
package si;

public final class Stateinfo {

   private static Stateinfo instance = null;

   private static String curdir;
   
   protected Stateinfo() {
         // Exists only to defeat instantiation.
      }

   public static Stateinfo getInstance() {
	      if(instance == null) {
	         instance = new Stateinfo();
	      }
	      return instance;
	   }   
   

   
   public void setCurdir(String cdir){
	   curdir = cdir;
	   return;
   }
   
   public String getCurdir(){
	   return curdir;
   }
   
}
