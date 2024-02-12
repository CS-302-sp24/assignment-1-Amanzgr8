import java.util.Random;

class Philosopher extends Thread {
  // below lies the instance variabls of the class
  private Chopstick left, right;
  private int nc, tt, et, rl, ID; 
  private Random random;

  // Here lies the generator of the class
  public Philosopher(Chopstick left, Chopstick right, int tt, int et, int nc, int rl, int ID) {
    this.left = left; this.right = right; this.tt = tt; this.et = et; this.nc = nc; this.rl = rl; this.ID = ID;
    random = new Random();
  }

  // below is the function that runs when a thread is started
  public void run() {
    try {
      if (nc == 0){  // if we want the cycle to continue forever
        while(true) {
          int x = random.nextInt(tt);    // line 21 and 22 sets the thinking time and eating time to a variable
          int y = random.nextInt(et);
          System.out.println("Philosopher " + ID + " thinks for " + x + " units");
          Thread.sleep(x);     // Think for a while

          if ( rl == 0){        // for when rl is zero, all philospoher are right handed
            System.out.println("Philosopher " + ID + " wants right chopstic");
            synchronized(right) {                    // Grab right chopstick 
              System.out.println("Philosopher " + ID + " has right chopstic");
              System.out.println("Philosopher " + ID + " wants left chopstic");
              synchronized(left) {                 // Grab left chopstick 
                System.out.println("Philosopher " + ID + " has left chopstic");
                System.out.println("Philosopher " + ID + " eats for " + y + " units");
                Thread.sleep(y); // Eat for a while
              }
            }
          }else if ( rl == 1 && ID %2 == 0){
            System.out.println("Philosopher " + ID + " wants right chopstic");
            synchronized(right) {                    // Grab right chopstick 
              System.out.println("Philosopher " + ID + " has right chopstic");
              System.out.println("Philosopher " + ID + " wants left chopstic");
              synchronized(left) {                 // Grab left chopstick 
                System.out.println("Philosopher " + ID + " has left chopstic");
                System.out.println("Philosopher " + ID + " eats for " + y + " units");
                Thread.sleep(y); // Eat for a while
              }
            }
          }else if ( rl == 1 && ID %2 != 0){
            System.out.println("Philosopher " + ID + " wants left chopstic");
            synchronized(left) {                    // Grab right chopstick 
              System.out.println("Philosopher " + ID + " has left chopstic");
              System.out.println("Philosopher " + ID + " wants right chopstic");
              synchronized(right) {                 // Grab left chopstick 
                System.out.println("Philosopher " + ID + " has right chopstic");
                System.out.println("Philosopher " + ID + " eats for " + y + " units");
                Thread.sleep(y); // Eat for a while
              }
            }
          }
        }
      }else{ // if we want the cycle to only run the specified amount
        while(nc > 0) {
          int x = random.nextInt(tt);
          int y = random.nextInt(et);
          System.out.println("Philosopher " + ID + " thinks for " + x + " units");
          Thread.sleep(x);     // Think for a while

          
          if ( rl == 0){
            System.out.println("Philosopher " + ID + " wants right chopstic");
            synchronized(right) {                    // Grab right chopstick 
              System.out.println("Philosopher " + ID + " has right chopstic");
              System.out.println("Philosopher " + ID + " wants left chopstic");
              synchronized(left) {                 // Grab left chopstick 
                System.out.println("Philosopher " + ID + " has left chopstic");
                System.out.println("Philosopher " + ID + " eats for " + y + " units");
                Thread.sleep(y); // Eat for a while
              }
            }
          }else if ( rl == 1 && ID %2 == 0){
            System.out.println("Philosopher " + ID + " wants right chopstic");
            synchronized(right) {                    // Grab right chopstick 
              System.out.println("Philosopher " + ID + " has right chopstic");
              System.out.println("Philosopher " + ID + " wants left chopstic");
              synchronized(left) {                 // Grab left chopstick 
                System.out.println("Philosopher " + ID + " has left chopstic");
                System.out.println("Philosopher " + ID + " eats for " + y + " units");
                Thread.sleep(y); // Eat for a while
              }
            }
          }else if ( rl == 1 && ID %2 != 0){
            System.out.println("Philosopher " + ID + " wants left chopstic");
            synchronized(left) {                    // Grab right chopstick 
              System.out.println("Philosopher " + ID + " has left chopstic");
              System.out.println("Philosopher " + ID + " wants right chopstic");
              synchronized(right) {                 // Grab left chopstick 
                System.out.println("Philosopher " + ID + " has right chopstic");
                System.out.println("Philosopher " + ID + " eats for " + y + " units");
                Thread.sleep(y); // Eat for a while
              }
            }
          }
          --nc;
        }
      }
    } catch(InterruptedException e) {}
  }
}
