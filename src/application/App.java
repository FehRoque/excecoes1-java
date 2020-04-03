package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class App {

	public static void main(String [] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("N�mero do quarto: ");
		int numeroDoQuarto = sc.nextInt();
		
		System.out.print("Data de entrada (DD/MM/AAAA): ");
		Date dataDeEntrada = sdf.parse(sc.next());
		
		System.out.print("Data de sa�da (DD/MM/AAAA): ");
		Date dataDeSaida = sdf.parse(sc.next());
		
		if (!dataDeSaida.after(dataDeEntrada)){
			System.out.println("Erro na reserva! A data de sa�da precisa ser posterior � data de entrada.");
		}
		else {
			Reserva reserva = new Reserva(numeroDoQuarto, dataDeEntrada, dataDeSaida);
			System.out.println();
			System.out.print(reserva); 
			
			
			System.out.println("Entre com os dados para atualiza��o de reserva: ");
			
			System.out.print("Data de entrada (DD/MM/AAAA): ");
			dataDeEntrada = sdf.parse(sc.next());
			
			System.out.print("Data de sa�da (DD/MM/AAAA): ");
			dataDeSaida = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(dataDeEntrada.before(agora) || dataDeSaida.before(agora)) {
				System.out.println("Erro na reserva! As datas para atualiza��es devem ser datas futuras.");
			}
			else if (!dataDeSaida.after(dataDeEntrada)){
				System.out.println("Erro na reserva! A data de sa�da precisa ser posterior � data de entrada.");
			}
			else {
				reserva.atualizaData(dataDeEntrada, dataDeSaida);
				System.out.print(reserva);				
			}
			
						
		}
		
		
		
		
		
		
		sc.close();
	}
}
