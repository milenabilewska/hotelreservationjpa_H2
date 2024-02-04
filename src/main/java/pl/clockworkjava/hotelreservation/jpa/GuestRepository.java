package pl.clockworkjava.hotelreservation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GuestRepository {

    EntityManager em;

    public GuestRepository(EntityManager em) {
        this.em = em;
    }

    public void createNewGuest(String name, int age) {

        Guest newOne = new Guest(name, age);
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(newOne);

        transaction.commit();
    }

    public Guest findById(long id) {
        return em.find(Guest.class, id);
    }

    public void updateAge(Guest guest, int newAge) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        guest.setAge(newAge);
        transaction.commit();
    }

    public void delete(Guest guest) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(guest);
        transaction.commit();
    }
}

