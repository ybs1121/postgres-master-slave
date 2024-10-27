package study.postgresmasterslave.test;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestRepository testRepository;
    private final EntityManager entityManager;
    @Transactional
    @PostMapping
    public String save() {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        entityManager.flush();
        return testEntity.toString();
    }

    @Transactional
    @DeleteMapping
    public String del() {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        return testEntity.toString();
    }


    @Transactional
    @PatchMapping
    public String patch() {
        Optional<TestEntity> byId = testRepository.findById(1L);
        TestEntity testEntity = byId.get();
        testEntity.setName("test");
        return testEntity.toString();
    }

    @Transactional(readOnly = true)
    @GetMapping
    public String get() {
        Optional<TestEntity> byId = testRepository.findById(1L);
        TestEntity testEntity = byId.get();
        return testEntity.toString();
    }
}
