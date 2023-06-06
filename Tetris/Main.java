public class Main {
    public static void main(String[] args) {

      System.out.println("Use WAD to rotate, move left, and move right respectively");
      Thread.sleep(5000);
      try {
        var frameBasedGameLoop = new FrameBasedGameLoop();
        frameBasedGameLoop.run();
      } catch (InterruptedException e) {
        //LOGGER.error(e.getMessage());
      } 

    }
  }