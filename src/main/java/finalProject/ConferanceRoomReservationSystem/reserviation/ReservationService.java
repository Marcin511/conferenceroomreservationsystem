package finalProject.ConferanceRoomReservationSystem.reserviation;


import finalProject.ConferanceRoomReservationSystem.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
@Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
   public Reservation AddReservation(Reservation reservation){
    reservationRepository.findByConferenceRoom_IdReservationStartLessAndReservationEndGreaterThan(reservation.getReservationName(),reservation.getReservationStart(),reservation.getReservationEnd()).ifPresent(r -> {
        throw new IllegalArgumentException("This reservation already exist chose another date");
    });
    return reservationRepository.save(reservation);
    }
    public List<Reservation> showReservation(SortType sortType){
    Sort sort = Sort.by(Sort.Direction.fromString(sortType.name()),"reservationName");
    return reservationRepository.findAll(sort);
    }
}
