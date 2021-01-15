package tratando_excecoes.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import tratando_excecoes.model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		System.out.print("Ckeck-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		// checkOut deve ser depois do checkIn
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = sdf.parse(sc.next());

			// Verifica se a data de check-in ou check-out são anteriores ao agora
			Date now = new Date(); // cria a uma variável now com a data de agora
			
			if (checkIn.before(now) || checkOut.before(now)) {
				
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
				
			} else if (!checkOut.after(checkIn)) {

				System.out.println("Error in reservation: Check-out date must be after check-in date");

			} else {
				
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
				
			}

			

		}
		sc.close();
	}

}
