package finalProject.ConferanceRoomReservationSystem.reserviation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByConferenceRoom_IdReservationStartLessAndReservationEndGreaterThan(String conferenceId, LocalDateTime ReservationStart,LocalDateTime ReservationEnd);
}
