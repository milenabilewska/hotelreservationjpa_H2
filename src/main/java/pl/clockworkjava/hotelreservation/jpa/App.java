package pl.clockworkjava.hotelreservation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

public class App {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager();

    public static void main(String[] args) {
        GuestRepository guestRepository = new GuestRepository(em);
        ReservationRepository reservationRepository = new ReservationRepository(em);
        guestRepository.createNewGuest("Paweł", 34);
        guestRepository.createNewGuest("Kinga", 37);
        Guest guest = guestRepository.findById(1l);
        Guest guest2 = guestRepository.findById(2l);

        reservationRepository.createReservation(Arrays.asList(guest, guest2));

        System.out.println(guest.toString());

        System.out.println(guest2.toString());
    }
}
