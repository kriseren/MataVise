//Easter Egg del programa de MataVise.
//Programa creado por el Vise con ayuda de Esco y Diego. 
package mataVise;
import java.util.*;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;


class egg 
{
    private static String respuesta;
    private static Scanner sc = new Scanner(System.in);

	//Método que imprime por pantalla la ficha técnica de Vise.
	public static void start()
	{

		System.out.println("\n--FICHA TÉCNICA-------------------------------------------SUJETO Nº45821-----");
		System.out.println("-                                                         _______________   -");
		System.out.println("- *DATOS PERSONALES*                                     |               |  -");
		System.out.println("- Nombre: Javier.                                        |               |  -");
		System.out.println("- Apellidos: Vicedo (Segundo Apellido Desconocido).      |               |  -");
		System.out.println("- Sexo: Poco.                                            |               |  -");
		System.out.println("- Habilidades especiales: Ninguna.                       |   Fotografía  |  -");
		System.out.println("- Estado Civil: Más solo que la una.                     | No Disponible |  -");
		System.out.println("-                                                        |_______________|  -");
		System.out.println("- *BIOGRAFÍA*                                                               -");
		System.out.println("- Javier nació en Ucrania en en el año 2003.                                -");
		System.out.println("- Un año más tarde, se mudó a España, más concretamente a Petrer.           -");
		System.out.println("- Allí, tuvo una infancia difícil, en la que afrontó serios problemas de    -");
		System.out.println("- adicción al Dalsy y otros jarabes similares.                              -");
		System.out.println("- Después de pasar unos años en desintoxicación, Javi comienza el insti y   -");
		System.out.println("- se convierte en uno de los hackers de Paco más buscados por la InterPol.  -");
		System.out.println("-                                                                           -");
		System.out.println("- *CRÍMENES COMETIDOS*                                                      -");
		System.out.println("-  1-. Asesinó a Maradona.                                                  -");
		System.out.println("-  2-. Se hizo una paja en el funeral d su abuela.                          -");
		System.out.println("-  3-. Es fan de la pizza con piña.                                         -");
		System.out.println("-  4-. Crimenes de guerra variados.                                         -");
		System.out.println("-  5-. Violó a la cabra del rey de Groenlandia.                             -");
		System.out.println("- (Para ver la lista completa de crímenes, introducir el código 7524324)    -");
		System.out.println("- (Para escuchar las ultimas palabras de Vise, introducir el código 8534096)-");
		System.out.println("-----------------------------------------------------------------------------");

	}

	//Método que muestra por pantalla la lista de crímenes cometidos por Vise.
	public static void list() 
	{
		int i=1;
		System.out.println();
		while(true)
		{
			if(selector(i)==null)
				break;
			System.out.println(selector(i));
            System.out.println("\nPulsa \"Intro\" para ver más o escribe \"Salir\" para volver al menú.");
            respuesta=sc.nextLine();
            respuesta=respuesta.toLowerCase();
            if(respuesta.equals("salir"))
                break;
            i++;
		}

	}

	//SELECTOR
    //Método que lee líneas del fichero de muertes CrimenVise.txt.
    public static String selector(int el)
    {
        try
        {
            FileReader file = new FileReader("files/CrimenVise.txt");
            BufferedReader lect = new BufferedReader(file);
            String causa="";
            for (int i=0; i<el; i++)
                causa = lect.readLine();
            return causa;
        }catch(IOException e){
            return "Salida de Error.";
        }
    }
}
