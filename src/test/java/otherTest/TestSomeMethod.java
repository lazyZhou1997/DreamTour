package otherTest;

import edu.scu.dreamTour.enums.ActivityStatusEnum;
import org.junit.Test;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/8/23 10:08
 * @ModifyBy:
 */
public class TestSomeMethod {

    /**
     * 测试枚举的equals
     */
    @Test
    public void enumEquals(){
        ActivityStatusEnum activityStatusEnum = ActivityStatusEnum.CANCEL_HOLD;
        assert activityStatusEnum.equals(ActivityStatusEnum.CANCEL_HOLD);
    }
}
