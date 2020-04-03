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
		
		System.out.print("Número do quarto: ");
		int numeroDoQuarto = sc.nextInt();
		
		System.out.print("Data de entrada (DD/MM/AAAA): ");
		Date dataDeEntrada = sdf.parse(sc.next());
		
		System.out.print("Data de saída (DD/MM/AAAA): ");
		Date dataDeSaida = sdf.parse(sc.next());
		
		if (!dataDeSaida.after(dataDeEntrada)){
			System.out.println("Erro na reserva! A data de saída precisa ser posterior à data de entrada.");
		}
		else {
			Reserva reserva = new Reserva(numeroDoQuarto, dataDeEntrada, dataDeSaida);
			System.out.println();
			System.out.print(reserva); 
			
			
			System.out.println("Entre com os dados para atualização de reserva: ");
			
			System.out.print("Data de entrada (DD/MM/AAAA): ");
			dataDeEntrada = sdf.parse(sc.next());
			
			System.out.print("Data de saída (DD/MM/AAAA): ");
			dataDeSaida = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(dataDeEntrada.before(agora) || dataDeSaida.before(agora)) {
				System.out.println("Erro na reserva! As datas para atualizações devem ser datas futuras.");
			}
			else if (!dataDeSaida.after(dataDeEntrada)){
				System.out.println("Erro na reserva! A data de saída precisa ser posterior à data de entrada.");
			}
			else {
				reserva.atualizaData(dataDeEntrada, dataDeSaida);
				System.out.print(reserva);				
			}
			
						
		}
		
		
		
		
		
		
		sc.close();
	}
}
