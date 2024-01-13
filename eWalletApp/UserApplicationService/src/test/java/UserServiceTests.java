import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    UserRepository userRepository;

    @Mock
    KafkaTemplate<String,String> kafkaTemplate;
    @InjectMocks
    UserService userService;


    @Test()
    public void testUserCreation() throws JsonProcessingException {
        User user = User.builder().name("Something").
                age(20).email("kartik@email").phone("438").build();

        userService.create(user);
        verify(userRepository, times(1)).save(any());
        verify(kafkaTemplate,times(1)).send(eq("user_created"),any());
    }
}
