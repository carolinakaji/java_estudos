package tratando_excecoes_ruim.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public void setCheckin(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public void setCheckout(Date checkOut) {
		this.checkOut = checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		// converte em dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {

		Date now = new Date(); // cria a uma variável now com a data de agora

		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null; // para indicar que não houve erros, retornar null
	}

	@Override
	public String toString() {

		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}

}
