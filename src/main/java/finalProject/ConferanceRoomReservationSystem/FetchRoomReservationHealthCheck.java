package finalProject.ConferanceRoomReservationSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.NamedContributor;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Component("FetchUsersAPI")
public class FetchRoomReservationHealthCheck implements CompositeHealthContributor {

    private Map<String, HealthContributor>
            contributors = new LinkedHashMap<>();


    private DhHealthCheck dbHealthCheck;

    public FetchRoomReservationHealthCheck(DhHealthCheck dbHealthCheck) {
        this.dbHealthCheck = dbHealthCheck;
        contributors.put("Database", dbHealthCheck);
    }

    @Override
    public HealthContributor getContributor(String name) {
        return getContributor(name);
    }

    @Override
    public Iterator<NamedContributor<HealthContributor>> iterator() {
        return contributors.entrySet().stream()
                .map((entry)-> NamedContributor.of(entry.getKey(), entry.getValue())).iterator();
    }
}