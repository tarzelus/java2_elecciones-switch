package com.zubiri.elecciones;
import java.util.Scanner;


public class Habitante {

			
		public String Dni;
		public String Nombre;
		public String Apellido;
		public int Edad;
		
//--------------------DNI--------------------------------	
		



		public String getDni()
		{
			return Dni;
		
		}
		
		public void  setDni(String DNI1)
		{
			Dni=DNI1;
		}


    //comprobacion del final del DNI sea contenga letra  

		public String correcto () 
		{
			
		
			if(!Dni.endsWith("a-z") || !Dni.endsWith("A-Z")) 
			{	
				
				Dni="\nEl DNI necesita letra";
			 }

		return Dni;
 		}




		
//--------------------nombre--------------------------------

		public String getNombre()
		{
			return Nombre;

			
		}
		
		public void  setNombre(String nombre1)
		{
			Nombre=nombre1;
		}

	
	
//---------------------apellido-------------------------------

		public String getApellido()
		{
			return Apellido;
		}
		
		public void  setApellido(String apellido1)
		{
			Apellido=apellido1;
		}



//--------------------fecha de nacimiento ------------------------

		public int getEdad()
		{
			return Edad;
		}
		
		public void  setEdad(int edad1)
		{
			Edad=edad1;
		}



	}

