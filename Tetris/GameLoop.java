import java.util.Random;
import java.util.Scanner;


  
public class GameLoop {
  
    //public final Logger logger = Logger.getLogger(this.getClass());
  
    public static GameStatus status;

    public Scanner myObj;
  
    public Tetris t;
  
    public Thread gameThread;
  
    public GameLoop(Tetris nt) {
      t = nt;
      status = GameStatus.STOPPED;
      myObj = new Scanner(System.in);
    }
  
    public void run() {
      status = GameStatus.RUNNING;
      gameThread = new Thread(this::processGameLoop);
      gameThread.start();
 
    }
  
    public static void stop() {
      status = GameStatus.STOPPED;
    }
  
    public boolean isGameRunning() {
      return status == GameStatus.RUNNING;
    }
  
    public void processInput() {
      while(isGameRunning()) {
        String move = myObj.nextLine();
        if(move.equals("a")) {t.left();}
        else if (move.equals("d")) {t.right();}
        else if (move.equals("w")) {t.rotate();}
      }

    return;
    }
  
    public void render() {
        t.print();
    }
  
    public void processGameLoop() {
        while (isGameRunning()) {
          processInput();
          update();
          render();
        }
      }
    
      public void update() {
        t.make();
      }
}
  
