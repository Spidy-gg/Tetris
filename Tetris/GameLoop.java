import java.util.Random;
import java.util.Scanner;


  
public abstract class GameLoop {
  
    //protected final Logger logger = Logger.getLogger(this.getClass());
  
    protected volatile GameStatus status;

    private Scanner myObj;
  
    protected Tetris t;
  
    private Thread gameThread;
  
    public GameLoop() {
      t = new Tetris();
      status = GameStatus.STOPPED;
      myObj = new Scanner(System.in);
    }
  
    public void run() {
      status = GameStatus.RUNNING;
      gameThread = new Thread(this::processGameLoop);
      gameThread.start();
 
    }
  
    public void stop() {
      status = GameStatus.STOPPED;
    }
  
    public boolean isGameRunning() {
      return status == GameStatus.RUNNING;
    }
  
    protected void processInput() {
      try {
        String move = myObj.nextLine();
        if(move.equals("a")) {t.left();}
        else if (move.equals("d")) {t.right();}
        else if (move.equals("w")) {t.rotate();}
      } catch (InterruptedException e) {
        //logger.error(e.getMessage());
      }
    }
  
    protected void render() {
        float position = controller.getBulletPosition();
        System.out.println(position);
    }
  
    protected void processGameLoop() {
        while (isGameRunning()) {
          processInput();
          update();
          render();
        }
      }
    
      protected void update() {
        controller.moveBullet(0.5f);
      }
}
  
