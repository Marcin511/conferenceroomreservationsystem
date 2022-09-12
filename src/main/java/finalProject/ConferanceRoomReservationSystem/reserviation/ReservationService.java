package finalProject.ConferanceRoomReservationSystem.reserviation;


import finalProject.ConferanceRoomReservationSystem.SortType;
import finalProject.ConferanceRoomReservationSystem.conference_room.ConferenceRoom;
import finalProject.ConferanceRoomReservationSystem.conference_room.ConferenceRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ReservationService {
    private static final int MIN_DURATION_OF_THE_MEETING = 15;

    private final ReservationRepository reservationRepository;
    private final ConferenceRoomRepository conferenceRoomRepository;

    ReservationService(ReservationRepository reservationRepository, ConferenceRoomRepository conferenceRoomRepository) {
        this.reservationRepository = reservationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    Reservation addReservation(Reservation reservation) {
        ConferenceRoom conferenceRoom = conferenceRoomRepository.findById(reservation.getConferenceRoom().getId())
                .orElseThrow(() -> new NoSuchElementException("Can't find conference room!"));
        if (!conferenceRoom.getAvailable()) {
            throw new IllegalArgumentException("Conference room is not available!");
        }
        if (reservation.getReservationEnd().isBefore(reservation.getReservationStart())){
            throw new IllegalArgumentException("end date is before start date!");
        }
        if (ChronoUnit.MINUTES.between(reservation.getReservationStart(), reservation.getReservationEnd()) <MIN_DURATION_OF_THE_MEETING){
            throw new IllegalArgumentException("meeting can't be shorter than " + MIN_DURATION_OF_THE_MEETING + " min!");
        }
        reservationRepository.findByConferenceRoom_IdReservationStartLessAndReservationEndGreaterThan(
                conferenceRoom.getId(),
                reservation.getReservationEnd(),
                reservation.getReservationStart()
        ).ifPresent(r->{
            throw new IllegalArgumentException("Reservation during provided time already exits");
        });
        return reservationRepository.save(reservation);
    }
}