public class DiningPhilosophers{
  // below lies the instance variables of this class
  private int np;
  private int nc;
  private int tt;
  private int et;
  private int rl;

  // below is the generator of the class
  public DiningPhilosophers(int np, int nc, int tt, int et, int rl){
    this.np = np;
    this.nc = nc;
    this.tt = tt;
    this.et = et;
    this.rl = rl;
  }

  public static void main(String[] args) throws InterruptedException {
    Philosopher[] philosophers = new Philosopher[5];
    Chopstick[] chopsticks = new Chopstick[5];
    DiningPhilosophers x = new DiningPhilosophers(5, 0, 1, 1, 0);  // calls the class with the paramerters
    
    for (int i = 0; i < x.np; ++i)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < x.np; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % 5], x.tt, x.et, x.nc, x.rl, i); // calls the philosophers class with the appropriate parameters 
      philosophers[i].start();
      // philosophers[i].join();
    }
    for (int i = 0; i < 5; ++i)
      philosophers[i].join();
  }
}
