package finalProject.ConferanceRoomReservationSystem.reserviation;

import finalProject.ConferanceRoomReservationSystem.conference_room.ConferenceRoom;
import org.springframework.stereotype.Component;

@Component
    class ReservationTransformer {

        ReservationDto toDto(Reservation reservation) {
            ReservationDto reservationDto = new ReservationDto();
            reservationDto.setId(reservation.getId());
            reservationDto.setReservationName(reservation.getReservationName());
            reservationDto.setStartDate(reservation.getReservationStart());
            reservationDto.setEndDate(reservation.getReservationEnd());
            reservationDto.setConferenceRoomId(reservation.getConferenceRoom().getId());
            return reservationDto;
        }

        Reservation fromDto(ReservationDto reservationDto) {
            Reservation reservation = new Reservation();
            reservation.setId(reservationDto.getId());
            reservation.setReservationStart(reservationDto.getStartDate());
            reservation.setReservationEnd(reservationDto.getEndDate());
            reservation.setReservationName(reservationDto.getReservationName());
            reservation.setConferenceRoom(new ConferenceRoom(reservationDto.getId()));
            return reservation;
        }
    }

