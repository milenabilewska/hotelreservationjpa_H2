package pl.clockworkjava.hotelreservation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.List;

public class ReservationRepository {

    private EntityManager em;

    public ReservationRepository(EntityManager em) {
        this.em = em;
    }

    public void createReservation(List<Guest> guests) {

        Reservation r = new Reservation(guests);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(r);
        transaction.commit();

    }
}
