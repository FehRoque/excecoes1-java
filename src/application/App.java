package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class App {

	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("N�mero do quarto: ");
			int numeroDoQuarto = sc.nextInt();
			
			System.out.print("Data de entrada (DD/MM/AAAA): ");
			Date dataDeEntrada = sdf.parse(sc.next());
			
			System.out.print("Data de sa�da (DD/MM/AAAA): ");
			Date dataDeSaida = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroDoQuarto, dataDeEntrada, dataDeSaida);
			
			System.out.println();
			System.out.print("Reserva: "+ reserva); 
			
			System.out.println();
			System.out.println("Entre com os dados para atualiza��o de reserva: ");
			
			System.out.print("Data de entrada (DD/MM/AAAA): ");
			dataDeEntrada = sdf.parse(sc.next());
			
			System.out.print("Data de sa�da (DD/MM/AAAA): ");
			dataDeSaida = sdf.parse(sc.next());
			
			System.out.println();
			
			reserva.atualizaData(dataDeEntrada, dataDeSaida);
			System.out.print("Reserva: "+ reserva);		
		}
		catch (ParseException e){
			System.out.println("Formato de data inv�lido.");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		sc.close();
	}
}
