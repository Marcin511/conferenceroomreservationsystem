package finalProject.ConferanceRoomReservationSystem;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component("Database")

public class DhHealthCheck implements HealthIndicator, HealthContributor {

    @Autowired
    private DataSource ds;

    @Override
    public Health health() {
        try(Connection connection = ds.getConnection()){
            Statement statement = connection.createStatement();
            statement.execute("select * from reservationsdsdsd");
        }catch (SQLException e) {
            return Health.outOfService().withException(e).build();
        }
        return Health.up().build();
    }
}