package finalProject.ConferanceRoomReservationSystem.organization;

import finalProject.ConferanceRoomReservationSystem.conference_room.ConferenceRoomTransformer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
class OrganizationTransformer {

    private final ConferenceRoomTransformer conferenceRoomTransformer;

    public OrganizationTransformer(ConferenceRoomTransformer conferenceRoomTransformer) {
        this.conferenceRoomTransformer = conferenceRoomTransformer;
    }

    OrganizationDto toDto(Organization organization) {
        return new OrganizationDto(
                organization.getId(),
                organization.getName(),
                organization.getDescription(),
                organization.getConferenceRooms().stream()
                        .map(conferenceRoomTransformer::toDto)
                        .collect(Collectors.toList())
        );
    }

    Organization fromDto(OrganizationDto organizationDto) {
        return new Organization(
                organizationDto.getId(),
                organizationDto.getName(),
                organizationDto.getDescription(),
                organizationDto.getConferenceRooms().stream()
                        .map(conferenceRoomTransformer::fromDto)
                        .collect(Collectors.toList())
        );
    }
}