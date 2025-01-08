import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FitnessRecordRepository fitnessRecordRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public FitnessRecord addFitnessRecord(FitnessRecord record) {
        return fitnessRecordRepository.save(record);
    }

    public List<FitnessRecord> getRecordsByUser(Long userId) {
        return fitnessRecordRepository.findAll().stream()
                .filter(record -> record.getUserId().equals(userId))
                .toList();
    }
}
