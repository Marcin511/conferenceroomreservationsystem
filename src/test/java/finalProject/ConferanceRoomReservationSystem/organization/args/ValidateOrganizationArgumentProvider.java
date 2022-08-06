package finalProject.ConferanceRoomReservationSystem.organization.args;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ValidateOrganizationArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(
                        """
                                {
                                  "description": "IT company",
                                  "name": "I"
                                }
                                """,
                        "size must be between 2 and 20"
                ),
                Arguments.of(
                        """
                                {
                                  "description": "IT company",
                                  "name": ""
                                }
                                """,
                        "must not be blank"
                ),
                Arguments.of(
                        """
                                {
                                  "description": "IT company"
                                }
                                """,
                        "must not be blank"
                )
        );
    }
}
