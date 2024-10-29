package go.backend_go.repository;

import go.backend_go.entity.Member;
import go.backend_go.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
