package finalProject.ConferanceRoomReservationSystem.organization.args;

import finalProject.ConferanceRoomReservationSystem.organization.Organization;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

public class GetByIdOrganizationArgumentProvider implements ArgumentsProvider {
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new Organization("Intive", "IT company"),
                                new Organization("Google", "IT company"),
                                new Organization("Uber", "Delivery company")
                        ),
                        1L,
                        Optional.of(new Organization(1L, "Intive", "IT company"))
                ),
                Arguments.of(
                        Collections.emptyList(),
                        1L,
                        Optional.empty()
                ),
                Arguments.of(
                        Arrays.asList(
                                new Organization("Intive", "IT company"),
                                new Organization("Google", "IT company"),
                                new Organization("Uber", "Delivery company")
                        ),
                        4L,
                        Optional.empty()
                )
        );
    }
}
