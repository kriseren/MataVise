//Programa creado por el Vise con ayuda de Esco y Diego. 
package mataVise;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;


public class mataVise
{
    //MAIN
    public static void main(String[] args) throws FileNotFoundException,JavaLayerException
    {
        Scanner sc= new Scanner(System.in);
        Utilidades.bannerInicio();
        System.out.println("Bienvenido al programa de eliminación del sujeto Vicedo con ID #"+Utilidades.ID);
        Utilidades.AreYouSure();
        Utilidades.cls();

        //Reproducción de la banda sonora.
        if(Utilidades.lectConf("set_music_on(true);"))
        {
            Bgm m = new Bgm();
            m.start();
        }
        

        //Llamada al menú.
        Utilidades.menu();
    }
}

//Clase que contiene la mayoría de métodos y utlidades del programa.
class Utilidades
{
    public static final int ID=45821;
    private static int eleccion;
    private static int eleccionMuerte;
    private static int menu;
    private static String muerte;
    private static String respuesta;
    private static Scanner sc = new Scanner(System.in);
    private static int n=720;

    //ARE YOU SURE
    //Método que pregunta al usuario antes de comenzar el programa.
    public static boolean AreYouSure()
    {
        for(int i=0; i<720; n++)
        {
            System.out.println("¿Estás seguro de matar al Vise?"); 
            respuesta = sc.nextLine();
            respuesta=respuesta.toLowerCase(); //Se puede escribir Si , si , SI , sI
            if(respuesta.equals("si"))
                break;
            else
                System.out.println("Que gay , dilo enserio");
        }
        return true;
    }

    //MENU
    //Método que muestra el menú principal.
    public static void menu() throws FileNotFoundException,JavaLayerException
    {

        //Definición de variables
        int op=0;

        //Función
        while(true)
        {
            Utilidades.bannerInicio();
            System.out.println("Bienvenido al programa de eliminación del sujeto Vicedo con ID #"+Utilidades.ID);

            System.out.println("\nElige un numero del menú para elegir una muerte o dejarla al Azar entre una de las disponibles en la lista de muerte Secreta jiji");
        System.out.print(" 1-.A la Suerte  \n 2-.Elegir yo \n 3-.Confidencial \n 0-.Salir (Me arrepentí)\nSelecciona una opción: ");

        op=sc.nextInt();
        switch(op)
            {
                case 1:System.out.println("\nIniciando Modo Aleatorio...");aleatorio();break;
                case 2:System.out.println("\nIniciando Modo Usuario...");usuario();break;
                case 3:System.out.println("\nEntrando al modo Confidencial...");confidencial();break;
                case 0:System.out.println("\nSaliendo del programa...");;System.exit(0);break;
                default:System.out.println("\nIntroduce un número valido porfa.");
            }
        }
    }

    //SELECTOR
    //Método que lee líneas del fichero de muertes MataVise.txt.
    public static String selector(int el)
    {
        try {
            FileReader file = new FileReader("files/.MataVise.txt");
            BufferedReader lect = new BufferedReader(file);
            String causa="";
            for (int i=0; i<el; i++)
                causa = lect.readLine();
            return causa;
        } catch(IOException e) {
            return "Salida de Error.";
        }
    }

    //ALEATORIO
    //Método que genera un ńúmeros de línea aleatorios para extraer muertes de Vise.
    public static void aleatorio()
    {
        sc.nextLine();
        while(true)
        {
            do
            {
                eleccion=1+(int)(Math.random()*1000);
            }
            while(selector(eleccion).equals(""));
                
            System.out.println(selector(eleccion));
            System.out.println("\nPulsa \"Intro\" para ver más o escribe \"menu\" para volver al menú.");
            respuesta=sc.nextLine();
            respuesta=respuesta.toLowerCase();
            if(respuesta.equals("menu"))
            {
                cls();
                break;
            }
        }
    }

    //USUARIO
    //Método que lee líneas introducidas por el usuario para mostrar muertes de Vise.
    public static void usuario() throws FileNotFoundException,JavaLayerException
    {
        int i=0;
        while(true)
        {
            System.out.print("\nElige un numero del 1 al 1000, para volver al menú pulsa 0 --> ");
            eleccionMuerte = sc.nextInt();

            //Si el número introducido es 0, sale del modo usuario.
            if(eleccionMuerte==0)
            {
                System.out.println("\n0. Vise Vive ~ Imposible ");
                cls();
                break;
            } 

            //Si el número introducido es el ID del Vise se entra al EasterEgg.
            if (eleccionMuerte==ID)
            {
                //Reproduce sonido de coin
                CoinSound c = new CoinSound();
                c.start();

                //Inicia el easter egg
                egg.start();
                break;
            }

            //Si el número introducido es el código de crímenes muestra la lista de crímenes del EasterEgg.
            if(eleccionMuerte==7524324)
            {
                egg.list();
                break;
            }

            //Si el número introducido es el código de últimas palabras reproduce el audio del testimonio de Vise.
            if(eleccionMuerte==8534096)
            {
                System.out.println("\nAntes de morir, el delegado Vise grabó una pequeña nota de voz. Estas son sus últimas palabras...");

                //Reproduce el testimonio
                Testimonio t = new Testimonio();
                t.start();
                break;
            }
            System.out.println();
            System.out.println(selector(eleccionMuerte));
            i++;

            //Si el contador de muertes seguidas es mayor a 25, se ejecuta lo siguiente. 
            if(i==10)
                System.out.println("\nPor favor, deja a Vise morir en paz.");
            if(i==25)
                System.out.println("\nEnserio, deja de matarle o su fantasma te perseguirá toda la vida.");
            if(i==72)
            {
                System.out.println("\n!Has entrado al mozo Pacifista!\nDebido a que has matado a Vise más de 72 veces seguidas, esta vez Vise vivirá.");
                break;
            }
        }  
    }

    //CONFIDENCIAL
    //Método que controla la tercera opción del menú y muestra una pista del easter egg.
    public static void confidencial()
    {
        int n;
        System.out.print("Introduce el número favorito de Vise: ");
        n = sc.nextInt();
        if (n==72)
        {
            System.out.println("Los datos introducidos son correctos. Para acceder a los datos confidenciales, introduce el ID del sujeto en la opción 2.");
        }
        else
        {
            System.out.println("Los datos introducidos son erróneos.");    
        }
    }

    //LECTOR DE CONFIGURACIÓN
    //Método que lee el archivo de configuración y comprueba si una característica está activa.
    public static boolean lectConf(String s)
    {
        String line;
        File f = new File("files/config.txt");
        try(FileReader fr = new FileReader(f);
            BufferedReader lect = new BufferedReader(fr);)
        {
            while((line=lect.readLine())!=null)
            {
                if(line.equals(s))
                    return true;
            }
            return false;
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //CLEAR SCREEN
    //Método que borra la pantalla.
    public static void cls()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    //BANNER INICIO
    //Método que imprime el banner del inicio del programa.
    public static void bannerInicio()
    {
        System.out.println("     ______  _______         _____   _________________      _____          ____      ____  ____          ______       ______");
        System.out.println("    |      \\/       \\    ___|\\    \\ /                 \\ ___|\\    \\        |    |    |    ||    |     ___|\\     \\  ___|\\     \\  ");
        System.out.println("   /          /\\     \\  /    /\\    \\______     ______//    /\\    \\       |    |    |    ||    |    |    |\\     \\|     \\     \\ ");
        System.out.println("  /     /\\   / /\\     ||    |  |    |  \\( /    /  )/  |    |  |    |      |    |    |    ||    |    |    |/____/||     ,_____/|");
        System.out.println(" /     /\\ \\_/ / /    /||    |__|    |   ' |   |   '   |    |__|    |      |    |    |    ||    | ___|    \\|   | ||     \\--'\\_|/");
        System.out.println("|     |  \\|_|/ /    / ||    .--.    |     |   |       |    .--.    |      |    |    |    ||    ||    \\    \\___|/ |     /___/|  ");
        System.out.println("|     |       |    |  ||    |  |    |    /   //       |    |  |    |      |\\    \\  /    /||    ||    |\\     \\    |     \\____|\\ ");
        System.out.println("|\\____\\       |____|  /|____|  |____|   /___//        |____|  |____|      | \\ ___\\/___ / ||____||\\ ___\\|_____|   |____ '     /|");
        System.out.println("| |    |      |    | / |    |  |    |  |`   |         |    |  |    |       \\ |   ||   | / |    || |    |     |   |    /_____/ |");
        System.out.println(" \\|____|      |____|/  |____|  |____|  |____|         |____|  |____|        \\|___||___|/  |____| \\|____|_____|   |____|     | /");
        System.out.println("    \\(          )/       \\(      )/      \\(             \\(      )/            \\(    )/      \\(      \\(    )/       \\( |_____|/ ");
        System.out.println("     '          '         '      '        '              '      '              '    '        '       '    '         '    )/  ");
    }
}
