//Programa creado por el Vise con ayuda de Esco y Diego. 
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;


public class MataVise
{
    //MAIN
    public static void main(String[] args) throws FileNotFoundException,JavaLayerException
    {
        Scanner sc= new Scanner(System.in);
        Utilidades.bannerInicio();
        System.out.println("Bienvenido al programa de eliminación del sujeto Vicedo con ID #"+Utilidades.ID);
        Utilidades.AreYouSure();

        //Reproducción de sonido
        //Sounds.bros();  

        

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
            respuesta=respuesta.toLowerCase();     //Se puede escribir Si , si , SI , sI
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
             System.out.println("\nElige un numero del menú para elegir una muerte o dejarla al Azar entre una de las disponibles en la lista de muerte Secreta jiji");
        System.out.print(" 1-.A la Suerte  \n 2-.Elegir yo \n 3-.Inventar una nueva (Not yet implemented)\n 0-.Salir (Me arrepentí)\nSelecciona una opción: ");

        op=sc.nextInt();
        switch(op)
            {
                case 1:System.out.println("\nIniciando Modo Aleatorio...");aleatorio();break;
                case 2:System.out.println("\nIniciando Modo Usuario...");usuario();break;
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
            FileReader file = new FileReader("MataVise.txt");
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
                break;
        }
    }

    //USUARIO
    //Método que lee líneas introducidas por el usuario para mostrar muertes de Vise.
    public static void usuario() throws FileNotFoundException,JavaLayerException
    {
        while(true)
        {
            System.out.print("\nElige un numero del 1 al 1000, para volver al menú pulsa 0 --> ");
            eleccionMuerte = sc.nextInt();

            //Si el número introducido es el ID del Vise se entra al EasterEgg.
            if (eleccionMuerte==ID)
            {
                //Reproduce sonido de coin
                Sounds.coin();
                egg.start();
                break;
            }

            //Si el número introducid es el código muestra la lista de crímenes del EasterEgg.
            if(eleccionMuerte==7524324)
            {
                egg.list();
                break;
            }
            System.out.println();
            System.out.println(selector(eleccionMuerte));
            if(eleccionMuerte==0)
            {
                System.out.println("0. Vise Vive ~ Imposible ");
                break;
            }  
        }
        
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



    