package dev.kartheek.BookMyShow.repository;

import dev.kartheek.BookMyShow.model.Actor;
import dev.kartheek.BookMyShow.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
