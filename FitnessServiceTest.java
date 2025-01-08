import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FitnessServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private FitnessRecordRepository fitnessRecordRepository;

    @InjectMocks
    private FitnessService fitnessService;

    public FitnessServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = fitnessService.addUser(user);
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }
}
