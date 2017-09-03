package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.domain.Participant;
import edu.scu.dreamTour.domain.TourActivity;
import edu.scu.dreamTour.enums.ActivityStatusEnum;
import edu.scu.dreamTour.enums.ActivityTypeEnum;
import edu.scu.dreamTour.enums.JoinStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/8/24 13:48
 * @ModifyBy:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TourActivityServiceTest {

    @Autowired
    private TourActivityService tourActivityService;

    /**
     * 测试通过
     * @throws Exception
     */
    @Test
    public void launchActivities() throws Exception {
        TourActivity tourActivity = new TourActivity();
        tourActivity.setActivityStatus(ActivityStatusEnum.HOLD__SUCCESS);
        tourActivity.setActivityType(ActivityTypeEnum.CIRY_TOUR);
        tourActivity.setAddress("梧州");
        tourActivity.setHoldDate(new Date());
        tourActivity.setCreateDate(new Date());
        tourActivity.setContent("冲浪");
        tourActivity.setAccount(2);

        MyUser user = new MyUser();
        user.setAccount(2);
        tourActivity.setHolder(user);

        tourActivityService.launchActivities(tourActivity);
    }

    /**
     * 测试通过
     * @throws Exception
     */
    @Test
    public void findAllActivityWillHold() throws Exception {

        System.out.println(tourActivityService.findAllActivityWillHold(1));

    }

    /**
     * 测试通过
     * @throws Exception
     */
    @Test
    public void participateActivity() throws Exception {
        Participant participant = new Participant();
        participant.setJoinStatus(JoinStatusEnum.JOIN_SUCCESS);//测试
        participant.setAccount(3);
        participant.setId(2);
        participant.setJoinDate(new Date());
        participant.setPersonnelIntroduction("勤劳勇敢，任劳任怨");

        MyUser user = new MyUser();
        user.setAccount(3);

        participant.setMyUser(user);

        tourActivityService.participateActivity(participant);
    }
}