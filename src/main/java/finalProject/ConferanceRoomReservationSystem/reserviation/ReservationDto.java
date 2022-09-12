package finalProject.ConferanceRoomReservationSystem.reserviation;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

interface AddReservation {

}

interface UpdateReservation {

}
public class ReservationDto {

        private String id;

        @NotNull(groups = AddReservation.class)
        private LocalDateTime reservationStart;
        @NotNull(groups = AddReservation.class)
        private LocalDateTime reservationEnd;



        @Size(min = 2, max = 20, groups = { AddReservation.class, UpdateReservation.class })
        private String reservationName;

        private String conferenceRoomId;

        public ReservationDto() {
        }

        public ReservationDto(String id, LocalDateTime startDate, LocalDateTime endDate, String reservationName, String conferenceRoomId) {
            this.id = id;
            this.reservationStart = startDate;
            this.reservationEnd = endDate;
            this.reservationName = reservationName;
            this.conferenceRoomId = conferenceRoomId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public LocalDateTime getStartDate() {
            return reservationStart;
        }

        public void setStartDate(LocalDateTime startDate) {
            this.reservationStart = startDate;
        }

        public LocalDateTime getEndDate() {
            return reservationEnd;
        }

        public void setEndDate(LocalDateTime endDate) {
            this.reservationEnd = endDate;
        }

        public String getReservationName() {
            return reservationName;
        }

        public void setReservationName(String reservationName) {
            this.reservationName = reservationName;
        }

        public String getConferenceRoomId() {
            return conferenceRoomId;
        }

        public void setConferenceRoomId(String conferenceRoomId) {
            this.conferenceRoomId = conferenceRoomId;
        }

        @Override
        public String toString() {
            return "ReservationDto{" +
                    "id='" + id + '\'' +
                    ", startDate=" + reservationStart +
                    ", endDate=" + reservationEnd +
                    ", reservationName='" + reservationName + '\'' +
                    ", conferenceRoomId='" + conferenceRoomId + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReservationDto that = (ReservationDto) o;
            return Objects.equals(id, that.id) && Objects.equals(reservationStart, that.reservationStart) && Objects.equals(reservationEnd, that.reservationEnd) && Objects.equals(reservationName, that.reservationName) && Objects.equals(conferenceRoomId, that.conferenceRoomId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, reservationStart, reservationEnd, reservationName, conferenceRoomId);
        }
    }

