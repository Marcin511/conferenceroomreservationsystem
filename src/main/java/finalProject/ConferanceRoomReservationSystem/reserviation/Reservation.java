package finalProject.ConferanceRoomReservationSystem.reserviation;

import finalProject.ConferanceRoomReservationSystem.conference_room.ConferenceRoom;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Reservation {
    public Reservation() {
    }

    @Id
    @GeneratedValue
    private Long id;
    private String ReservationName;
    private LocalDateTime ReservationStart;
    private LocalDateTime ReservationEnd;
    @ManyToOne
    @JoinColumn(name = "conference_room_id")
    private ConferenceRoom conferenceRoom;

    public ConferenceRoom getConferenceRoom() {
        return conferenceRoom;
    }

    public Reservation(Long id, String reservationName, LocalDateTime reservationStart, LocalDateTime reservationEnd,ConferenceRoom conferenceRoom) {
        this.id = id;
        ReservationName = reservationName;
        ReservationStart = reservationStart;
        ReservationEnd = reservationEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReservationName() {
        return ReservationName;
    }

    public void setReservationName(String reservationName) {
        ReservationName = reservationName;
    }

    public LocalDateTime getReservationStart() {
        return ReservationStart;
    }

    public void setReservationStart(LocalDateTime reservationStart) {
        ReservationStart = reservationStart;
    }

    public LocalDateTime getReservationEnd() {
        return ReservationEnd;
    }

    public void setReservationEnd(LocalDateTime reservationEnd) {
        ReservationEnd = reservationEnd;
    }
}


