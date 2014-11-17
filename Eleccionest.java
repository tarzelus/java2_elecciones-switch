import com.zubiri.elecciones.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;




public class Eleccionest {

	public static void main (String args[]) throws IOException{

		Scanner sc = new Scanner(System.in);

		System.out.print("\nh) habitantes");
		System.out.print("\ni) inmueble");
		System.out.print("\ne) espaciopublico");
		System.out.print("\na) ayuntamiento");
		System.out.print("\np) partidos");

		System.out.print("\nQue quieres hacer?");
				String hacer = sc.next();
				char caracter = hacer.charAt(0);

		switch (caracter)
       	{
		//-------------------------------------------habitante------------------------------------------------
		
 		 case 'h':
		{

			String DNI, nombre, apellido, denuevo;
			int edad;
		
			Habitante habitante = new Habitante();

			System.out.print("\n-------------introduce los datos del habitante------------------");	

			//*******************herramientas para escribir en el fichero****************************
			try 
			{
				
				String ruta = "/home/zubiri/Proyectosjava/java2_elecciones/censo.txt";
 
				FileWriter fw = new FileWriter(ruta , true);
				BufferedWriter bw = new BufferedWriter(fw);
		
			


		

				//pregunta por primera vez para escribir el nombre del habitante y pregunta para agregar un nombre mas a la lista
				do{
		
				//comprueba que el DNI inglresado tiene el numero de caracteres que tiene que tener un DNI		
					do{
						System.out.print("\ningresa el numero del DNI con letra (8 numeros y 1 letra): ");
						DNI = sc.next();
						habitante.setDni(DNI);
					} while (DNI.length() >9 || DNI.length() < 9);
			
					bw.write(DNI + ",");

					System.out.print("\ningresa el Nombre del habitante: ");
					nombre = sc.next();
					habitante.setNombre(nombre);
					bw.write(nombre + ",");
			
					System.out.print("\ningresa el apellido del hahbitante: ");
					apellido = sc.next();
					habitante.setApellido(apellido);
					bw.write(apellido + ",");

					System.out.print("\ningresa la edad del habitante: ");
					edad = sc.nextInt();
					habitante.setEdad(edad);
					bw.write(edad + "\n");

					bw.close();
					System.out.print("\nquieres insertar otro habitante? (si/no)");
					denuevo = sc.next();
		

				}while (denuevo.equalsIgnoreCase("si"));

		

			
        		}
			catch (FileNotFoundException e) 
			{
           			 System.out.println(e.getMessage());
       	 	}


		
       	 	//********************************Herramientas para leer el fichero*********************

			String nombrefichero2 = "censo.txt";	
			String ruta2 ="/home/zubiri/Proyectosjava/java2_elecciones";
			
			
			//lectura del fichero censo.txt	
			File archivo2 = new File(ruta2, nombrefichero2);
			FileReader leer2 = new FileReader (archivo2);
			BufferedReader bf2 = new BufferedReader(leer2);
			

 			//creacion de arraylist para ir metiendo los datos del txt
			ArrayList<Habitante> habitantes = new ArrayList<Habitante>();
		
			String salida2 = bf2.readLine();

			do
			{
				// se le da valor a la variable de salida de tipo string de la linea que lee
				
				//Coje el valor de string que tiene la linea completa y lo divide en diferentes secciones
				String [] cortarString = salida2.split(",");	
			
				//se le da valor a cada Atributo del objeto de tipo habitante
				Habitante habi = new Habitante(); 
				habi.setDni(cortarString[0]);
				habi.setNombre(cortarString[1]);
				habi.setApellido(cortarString[2]);
				habi.setEdad(Integer.parseInt(cortarString[3]));
				//si el habitante introducido es mayor de edad lo añadira al censo
					if (Integer.parseInt(cortarString[3]) >= 18)
					{

						//Despues de darle valor a cada atributo del objeto de tipo habitante todos estos se le asignan
						//   al objeto de arraylist de tipo habitante
						habitantes.add(habi);
					}
			
			
			

						

			} while ((salida2 = bf2.readLine()) != null);
			//la condicion del while es que seguira ejecutando siempre que tenga escrita la siguiente linea
     

     		System.out.println("Estos son los datos de los censados: ");

			//imprimira la informacion del arraylist del objeto de habitantes
			for(int t=0; t<habitantes.size(); t++)
        	{
         	   System.out.println("  --------------------------");
            	System.out.println("  |  Dni "+habitantes.get(t).getDni() );
           	 	System.out.println("  |  nombre:: "+habitantes.get(t).getNombre());
            	System.out.println("  |  Apellido: "+ habitantes.get(t).getApellido());
            	System.out.println("  |  Edad: "+ habitantes.get(t).getEdad());
       		 }	
			

		}
		break;

			//-------------------------------------------Inmueble------------------------------------------------	

 		case 'i':
		{


			String direccion, provincia, localidad, fecha_construc;
			int cod_postal;

			Inmueble inmueble = new Inmueble();

			System.out.print("\n-------------Datos del inmueble------------------");	


			System.out.print("\ningresa la dirección del inmueble: ");
			direccion = sc.nextLine();
			inmueble.setDireccion(direccion);

			System.out.print("\ningresa el nombre de la provivncia del inmueble: ");
			provincia = sc.next();
			inmueble.setProvincia(provincia);

			System.out.print("\ningresa la localidad del inmueble: ");
			localidad = sc.next();
			inmueble.setLocalidad(localidad);

			System.out.print("\nIngresa el  codigo postal del inmueble:  ");
			cod_postal = sc.nextInt();
			inmueble.setCod_postal(cod_postal);

			System.out.print("\nIngresa la fecha de construccion del inmueble ");
			fecha_construc = sc.next();
			inmueble.setFecha_construc(fecha_construc);


			//Impresion del inmueble

			System.out.print("\n-------------Estos son los datos del inmueble------------------");	

			System.out.println("\nLa direccion del inmueble: " + inmueble.getDireccion());
			System.out.println("\nProvincia del inmueble : " + inmueble.getProvincia());
			System.out.println("\nLocalidad del inmueble: " + inmueble.getLocalidad());
			System.out.println("\nCódigo postal del inmueble: " + inmueble.getCod_postal());
			System.out.println("\nFecha de construcción del inmueble: " + inmueble.getFecha_construc());


		}
		break;

		//-------------------------------------------Espacio Publico------------------------------------------------

 		case 'e':
		{



			String direccione, tipo, localidade;

			EspacioPublico espaciopublico = new EspacioPublico();
		
			System.out.print("\n-------------Espacio publico------------------");

			System.out.print("\ningresa el tipo de espacio publico ");
			tipo = sc.next();
			espaciopublico.setTipo(tipo);

	
			System.out.print("\ningresa la localidad del espacio publico: ");
			localidade = sc.next();
			espaciopublico.setLocalidad(localidade);	
	
			System.out.print("\ningresa la direccion del espacio publico ");
			direccione = sc.next();
			espaciopublico.setDireccion(direccione);

			//impresion de espacio publilco

			System.out.print("\n-------------Estos son los datos del espacio publico------------------");	

			System.out.println("\nEste es el tipo de espacio publico que es: " + espaciopublico.getTipo());
			System.out.println("\nLocalidad del espacio publico: " + espaciopublico.getLocalidad());
			System.out.println("\nLa direccion del espacio publico: " + espaciopublico.getDireccion());

		
		}
		break;

		//-----------------------------------------Ayuntamiento---------------------------------------------
		
		case 'a':
		{

 			String localidada,alcalde,gobierno,cod_postala;		
 			int populacion,censo;
			double extension;
		 
			Ayuntamiento ayuntamiento = new Ayuntamiento();

			System.out.print("\n-------------Ayuntamiento------------------");

			System.out.print("\ningresa la localidad del ayuntamiento: ");
			localidada = sc.next();
			ayuntamiento.setLocalidad(localidada);	
	
			System.out.print("\ningresa el nombre del alcalde: ");
			alcalde = sc.next();
			ayuntamiento.setAlcalde(alcalde);

			System.out.print("\ningresa el partido del alcalde: ");
			gobierno = sc.next();
			ayuntamiento.setGobierno(gobierno);

			System.out.print("\ningresa el codigo postal que abarcarca el ayuntamiento: ");
			cod_postala = sc.next();
			ayuntamiento.setCod_postal(cod_postala);

			System.out.print("\nIngresa la extensio de los terrenos del ayuntamientos: ");
			extension = sc.nextDouble();
			ayuntamiento.setExtension(extension);

			System.out.print("\ningresa la populacion de la ciudad:  ");
			populacion = sc.nextInt();
			ayuntamiento.setPopulacion(populacion);

			System.out.print("\ningresa la censo de la ciudad:  ");
			censo = sc.nextInt();
			ayuntamiento.setCenso(censo);

			//impreion de los datos de ayuntamiento

			System.out.print("\n-------------Estos son los datos del Ayuntamiento------------------");	

			System.out.println("\nLocalidad: " + ayuntamiento.getLocalidad());
			System.out.println("\nAlcalde: " + ayuntamiento.getAlcalde());
			System.out.println("\nGobierno: " + ayuntamiento.getGobierno());
			System.out.println("\nCodigo postal: " + ayuntamiento.getCod_postal());
			System.out.println("\nExtension de los terrenos: " + ayuntamiento.getExtension());
			System.out.println("\nPopulacion:  " + ayuntamiento.getPopulacion());
			System.out.println("\nGente censada: " + ayuntamiento.getCenso());


		}
		break;
		//-----------------------------------------partidos---------------------------------------------

		case 'p':
		{

			//lectura del fichero listadosPartidos.txt y guardarlos en un arraylist para imprimirlos


			System.out.print("\n----------------------------Lista de partidos-----------------------------------\n");
	


			String nombrefichero3 = "listadosPartidos.txt";
			String ruta3 ="/home/zubiri/Proyectosjava/java2_elecciones";
			ArrayList<Partido> partidos = new ArrayList<Partido>();


			int i = 0;

			
			//lectura del fichero	
			File archivo3 = new File(ruta3, nombrefichero3);
			FileReader leer3 = new FileReader (archivo3);
			BufferedReader bf3 = new BufferedReader(leer3);
			String salida3 = bf3.readLine();
 

			


			do
			{
				// se le da valor a la variable de salida de tipo string de la linea que lee
				
				//Coje el valor de string que tiene la linea completa y lo divide en diferentes secciones
				String [] cortarString = salida3.split(",");	
			
				//se le da valor a cada tributo del partido
				Partido part = new Partido(); 
				part.setNombre(cortarString[0]);
				part.setLider(cortarString[1]);
				part.setIdeologia(cortarString[2]);
				part.setCant_militantes(Integer.parseInt(cortarString[3]));
				part.setPrevias_elecciones(Integer.parseInt(cortarString[4]));
			
				//el valor que se le ha dado a cada atributo se lo pasa al objeto de tipo arraylist de partido
				partidos.add(part);

						

			} while ((salida3 = bf3.readLine()) != null);

     
			System.out.println("--estos son los partidos politicos que hay disponibles ");

			for(int d=0; d<partidos.size(); d++)
        	{
            	System.out.println("  ---------------------------------\n");
            		System.out.println(" nombre: "+partidos.get(d).getNombre() );
            		System.out.println(" \nlider: "+partidos.get(d).getLider());
            		System.out.println(" \nideologia: "+ partidos.get(d).getIdeologia());
            		System.out.println(" \nCantidad de militantes: "+ partidos.get(d).getCant_militantes());
            		System.out.println(" \nCantidad de militantes: "+ partidos.get(d).getPrevias_elecciones());
        	}	
			

        }
        break;
        //cerrando ek switch
		}
	}

}
