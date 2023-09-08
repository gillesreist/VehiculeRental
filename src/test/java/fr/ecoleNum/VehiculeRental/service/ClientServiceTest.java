package fr.ecoleNum.VehiculeRental.service;

import fr.ecoleNum.VehiculeRental.exception.ClientIdNotFoundException;
import fr.ecoleNum.VehiculeRental.model.Client;
import fr.ecoleNum.VehiculeRental.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientMockRepo;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void testIsMajor() {
        //different birthDate : 08/09/2000, 08/09/2010, 08/09/2020, 08/09/2030 Exception
        Client[] clientTested = {
                new Client(new Timestamp(968405192)),
                new Client(new Timestamp(1283937992)),
                new Client(new Timestamp(1599549717)),
                new Client(new Timestamp(1915082517)),
                null
        };
        Boolean[] resultExpected = {
                true,
                false,
                false,
                false,
                null
        };
        for (int i = 0; i < clientTested.length; i++) {
            when(clientMockRepo.findById(i)).thenReturn(Optional.ofNullable(clientTested[i]));
        }

        for (int i = 0; i < clientTested.length; i++) {
            try {

                boolean expected = Boolean.TRUE.equals(resultExpected[i]);
                boolean obtained = clientService.isAdult(i);
                assert( obtained == expected);
            } catch (ClientIdNotFoundException e) {
                assert (resultExpected[i] == null);
            }
        }

    }

}
