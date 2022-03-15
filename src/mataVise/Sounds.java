//Clase que contiene los métodos que reproducen sonidos.
package mataVise;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

//BACKGROUND MUSIC
//Clase que hace sonar el SoundTrack del juego.
class Bgm extends Thread {
   @Override
   public void run()
   {
      try
      {
         while (true)
         {
            Player apl = new Player(new FileInputStream("sounds/SoundTrack.mp3"));
            apl.play();
            Thread.sleep(1000);
         }
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Bug");
      }
      catch(JavaLayerException e)
      {
         System.out.println("Bug");
      }
      catch(InterruptedException e)
      {
         System.out.println("Bug");
      }
   }
}

//COINSOUND
//Clase que hace sonar el sonido de la moneda de Mario Bros.
class CoinSound extends Thread {
   @Override
   public void run() {
      try
      {
         Player apl = new Player(new FileInputStream("sounds/coin.mp3"));
         apl.play();
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Bug");
      }
      catch(JavaLayerException e)
      {
         System.out.println("Bug");
      }
   }
}