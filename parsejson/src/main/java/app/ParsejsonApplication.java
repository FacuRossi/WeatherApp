package app;

import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ParsejsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParsejsonApplication.class, args);

		ParseJson parser = new ParseJson();

		//Incrementar un 10% el scoring de los ingenieros sin importar la especialidad
		parser.increaseScoring(10);

		//Incrementar un 12% adicional el scoring de los ingenieros en computación
		parser.increaseScoring(12,"Computer Engineer");

		// Agregar un nuevo profesional: Carl Mick,Lawyer,11265
		parser.addProfessional("Carl Mick","Lawyer", 11265.0);

		//Ordenar el array por especialidad (alfabético ascendente)
		parser.sortByPosition();

		// En el caso de que la especialidad tenga varios postulantes, ordenarlo por scoring (de mínimo al mayor)
		parser.sortByScoringIf();

		//Agregar en cada elemento la ultima posición que tiene cada profesional
		parser.setFinalsPositions();

		//Guardar el array en un archivo plano y mostrarlo por pantalla
		System.out.println("*********************************\n");
		System.out.println(parser.toString());
		System.out.println("*********************************\n");
		try{
			parser.writeFileWithJsonData("./professionalList.txt");
		}catch(IOException e){
			System.out.println("Error al Crear el Archivo " + e.getMessage());
		}

	}
}
