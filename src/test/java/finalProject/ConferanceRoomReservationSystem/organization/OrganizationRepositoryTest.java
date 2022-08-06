package finalProject.ConferanceRoomReservationSystem.organization;

import finalProject.ConferanceRoomReservationSystem.organization.args.GetAllOrganizationArgumentProvider;
import finalProject.ConferanceRoomReservationSystem.organization.args.GetByIdOrganizationArgumentProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class OrganizationRepositoryTest {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    TestEntityManager testEntityManager;


    @ParameterizedTest
    @ArgumentsSource(GetAllOrganizationArgumentProvider.class)
    void when_arg_0_data_are_available_in_repo_then_find_all_should_return_arg_1_list(List<Organization> argO, List<Organization> arg1) {
        //given
        argO.forEach(o -> testEntityManager.persist(o));

        //when
        List<Organization> results = organizationRepository.findAll();

        //then
        assertEquals(arg1, results);
    }

    @ParameterizedTest
    @ArgumentsSource(GetByIdOrganizationArgumentProvider.class)
    void when_find_by_arg_1_when_arg_0_list_is_available_then_arg_2_item_should_be_returned(List<Organization> arg0,
                                                                                            String arg1,
                                                                                            Optional<Organization> arg2) {
        //given
        arg0.forEach(o -> testEntityManager.persist(o));

        //when
        Optional<Organization> result = organizationRepository.findById(Long.valueOf(arg1));

        //then
        assertEquals(arg2, result);
    }

    @Test
    void when_save_arg_0_to_repo_then_it_should_be_stored_properly() {
        //given
        Organization arg0 = new Organization("Intive", "It company");

        //when
        organizationRepository.save(arg0);

        //then
        assertEquals(arg0, testEntityManager.find(Organization.class, "Intive"));
    }

    @Test
    void when_save_arg_0_with_wrong_primary_key_then_exception_should_be_thrown() {
        //given
        Organization arg0 = new Organization(null, "It company");

        //when
        //then
        assertThrows(JpaSystemException.class, () -> {
            organizationRepository.save(arg0);
        });
    }
}