import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FitnessController {
    @Autowired
    private FitnessService fitnessService;

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return fitnessService.addUser(user);
    }

    @PostMapping("/records")
    public FitnessRecord addFitnessRecord(@RequestBody FitnessRecord record) {
        return fitnessService.addFitnessRecord(record);
    }

    @GetMapping("/records/{userId}")
    public List<FitnessRecord> getRecordsByUser(@PathVariable Long userId) {
        return fitnessService.getRecordsByUser(userId);
    }
}
