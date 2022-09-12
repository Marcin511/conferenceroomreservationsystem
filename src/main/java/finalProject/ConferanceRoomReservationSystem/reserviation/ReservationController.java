package finalProject.ConferanceRoomReservationSystem.reserviation;

import finalProject.ConferanceRoomReservationSystem.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
@Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping
    Reservation add(@RequestBody Reservation reservation){
    return reservationService.addReservation(reservation);
    }
//    @GetMapping
//    List<Reservation>showReservation(@RequestParam(defaultValue = "ASC")SortType sortType){
//    return reservationService.showReservation(sortType);
//    }
}
