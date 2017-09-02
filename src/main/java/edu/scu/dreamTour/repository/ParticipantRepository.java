package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.domain.IdClass.ParticipantIdClass;
import edu.scu.dreamTour.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 周秦春
 * @Description: 对Participant的操作接口
 * @Date: Create in 2017/8/24 17:09
 * @ModifyBy:
 */
public interface ParticipantRepository extends JpaRepository<Participant,ParticipantIdClass> {

}
