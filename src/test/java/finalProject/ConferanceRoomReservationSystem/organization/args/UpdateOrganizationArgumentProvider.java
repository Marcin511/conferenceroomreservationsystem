package finalProject.ConferanceRoomReservationSystem.organization.args;

import finalProject.ConferanceRoomReservationSystem.organization.Organization;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UpdateOrganizationArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                //name
                //existing org
                //to update
                //expected
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery company"),
                        new Organization(null, "IT company"),
                        new Organization("Intive", "IT company")
                ),
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery company"),
                        new Organization("Tieto", null),
                        new Organization("Tieto", "Delivery company")
                ),
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery company"),
                        new Organization("Tieto", "IT company"),
                        new Organization("Tieto", "IT company")
                ),
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery company"),
                        new Organization(null, null),
                        new Organization("Intive", "Delivery company")
                )
        );
    }
}
