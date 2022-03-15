//Clase que contiene los métdos que reproucen sonidos.
package mataVise;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

//BACKGOUND MUSIC
//Clase que controla la reproducción de la banda sonora.
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
            Thread.sleep(0);
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

//COIN SOUND
//Clase que controla la reproducción del sonido de moneda.
class CoinSound extends Thread {
   @Override
   public void run()
   {
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