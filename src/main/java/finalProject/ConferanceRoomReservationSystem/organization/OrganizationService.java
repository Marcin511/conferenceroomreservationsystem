package finalProject.ConferanceRoomReservationSystem.organization;

import finalProject.ConferanceRoomReservationSystem.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationTransformer organizationTransformer;
    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, OrganizationTransformer organizationTransformer) {
        this.organizationRepository = organizationRepository;
        this.organizationTransformer = organizationTransformer;
    }

    List<OrganizationDto> getAllOrganizations(SortType sortType) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortType.name()), "name");
        return organizationRepository.findAll(sort).stream()
                .map(organizationTransformer::toDto)
                .collect(Collectors.toList());
    }

    Organization getOrganization(String name) {
        return organizationRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("No organization exists!"));
    }

    Organization addOrganization(Organization organization) {
        organizationRepository.findByName(organization.getName()).ifPresent(o -> {
            throw new IllegalArgumentException("Organization already exists!");
        });
        return organizationRepository.save(organization);
    }

    Organization deleteOrganization(String name) {
        Organization organization = organizationRepository.findByName(name).orElseThrow(() -> new NoSuchElementException(""));
        organizationRepository.deleteById(organization.getId());
        return organization;
    }

    Organization updateOrganization(String name, Organization organization) {
        Organization organizationToUpdate = organizationRepository
                .findByName(name)
                .orElseThrow(() -> new NoSuchElementException(""));
        if (organization.getDescription() != null) {
            organizationToUpdate.setDescription(organization.getDescription());
        }
        if (organization.getName() != null && !organization.getName().equals(organizationToUpdate.getName())) {
            organizationRepository.findByName(organization.getName())
                    .ifPresent(o -> {
                        throw new IllegalArgumentException("Organization already exists!");
                    });
            organizationToUpdate.setName(organization.getName());
        }
        return organizationRepository.save(organizationToUpdate);
    }
}
