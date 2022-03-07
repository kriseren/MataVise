//Clase que contiene los métdos que reproucen sonidos.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class Sounds {

   public static void bros() throws FileNotFoundException,JavaLayerException
   {

      Player apl = new Player(new FileInputStream(".sounds/Bros.mp3"));
      apl.play();
   }

   public static void coin() throws FileNotFoundException,JavaLayerException
   {

      Player apl = new Player(new FileInputStream(".sounds/coin.mp3"));
      apl.play();
   }
}