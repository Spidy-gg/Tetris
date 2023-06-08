public class Main {
    public static void main(String[] args) {

      System.out.println("Use WAD to rotate, move left, and move right respectively");
      
      

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("null");
      } 

      Tetris t = new Tetris();
      GameLoop f = new GameLoop(t);
      f.run();
      t.make();


    }
  }