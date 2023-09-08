package fr.ecoleNum.VehiculeRental.service;

import fr.ecoleNum.VehiculeRental.exception.ClientIdNotFoundException;
import fr.ecoleNum.VehiculeRental.model.Client;
import fr.ecoleNum.VehiculeRental.repository.ClientRepository;
import fr.ecoleNum.VehiculeRental.service.util.DateFunctions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test void testAge(){
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("2013-09-09 00:00:00")),9);
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("2013-09-08 00:00:00")),10);
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("2013-09-07 00:00:00")),10);
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("0001-01-07 00:00:00")),2022);
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("0001-12-07 00:00:00")),2021);
    }
    @Test
    public void testIsMajor() {
        Client[] clientTested = {
                new Client(Timestamp.valueOf("2000-09-08 00:00:00.0")),
                new Client(Timestamp.valueOf("2010-09-08 00:00:00.0")),
                new Client(Timestamp.valueOf("2020-09-08 00:00:00.0")),
                new Client(Timestamp.valueOf("2030-09-08 00:00:00.0")),
                null,
                new Client(new Timestamp(System.currentTimeMillis()))
        };
        Boolean[] resultExpected = {
                true,
                false,
                false,
                false,
                null,
                false
        };
        for (int i = 0; i < clientTested.length; i++) {
            when(clientMockRepo.findById(i)).thenReturn(Optional.ofNullable(clientTested[i]));
        }

        for (int i = 0; i < clientTested.length; i++) {
            try {

                boolean expected = Boolean.TRUE.equals(resultExpected[i]);
                boolean obtained = clientService.isAdult(i);
                assertEquals (expected, obtained,"testIsMajor: test " + (i+1) + " failed.");

            } catch (ClientIdNotFoundException e) {
                assert (resultExpected[i] == null);
            }
        }

    }

}
