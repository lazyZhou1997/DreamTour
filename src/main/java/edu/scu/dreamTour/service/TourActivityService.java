package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.domain.Participant;
import edu.scu.dreamTour.domain.TourActivity;
import edu.scu.dreamTour.domain.result.PageResult;
import edu.scu.dreamTour.enums.ActivityStatusEnum;
import edu.scu.dreamTour.enums.ExceptionEnum;
import edu.scu.dreamTour.enums.JoinStatusEnum;
import edu.scu.dreamTour.exception.TourDreamException;
import edu.scu.dreamTour.properties.TourDreamProperties;
import edu.scu.dreamTour.repository.MyUserRepository;
import edu.scu.dreamTour.repository.ParticipantRepository;
import edu.scu.dreamTour.repository.TourActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import utils.PageResultUtils;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 用于处理旅游活动相关的服务类
 * @Date: Create in 2017/8/22 11:45
 * @ModifyBy:
 */
@Service
public class TourActivityService {

    /**
     * 操作旅游活动数据的接口
     */
    @Autowired
    private TourActivityRepository tourActivityRepository;

    /**
     * 操作用户数据的接口
     */
    @Autowired
    private MyUserRepository myUserRepository;

    /**
     * 操作Participant数据接口
     */
    @Autowired
    private ParticipantRepository participantRepository;

    /**
     * 定义的配置信息，包含分页大小
     */
    @Autowired
    private TourDreamProperties tourDreamProperties;

    /**
     * 将发起的活动添加到数据库中
     * @param tourActivity 待添加的活动,需要holder,以及活动的全部基础信息
     */
    @Transactional
    public void launchActivities(TourActivity tourActivity){

        //查看数据库中活动举办者是否已经开始举办其他活动，如果是，就不能再举办活动
        //数据库中查看举办者
        MyUser holder;
        holder = myUserRepository.findOne(tourActivity.getAccount());
        //查看该举办者在数据库中举办的其他活动
        Set<TourActivity> tourActivities = holder.getTourActivities();
        //如果有其他未完成的活动,则抛出异常
        for (TourActivity t:
             tourActivities) {
            if (!t.isComplete()){
                throw new TourDreamException(ExceptionEnum.HAS_OTHER_TO_HOLD);
            }
        }

        //设置活动状态为待审核
        tourActivity.setActivityStatus(ActivityStatusEnum.AUDITING);
        System.out.println("活动账号"+tourActivity.getAccount());
        //添加该活动
        tourActivityRepository.save(tourActivity);
    }

    /**
     * 查找数据库中所有等待举办的活动，并且返回分页结果给调用方
     * @param pageIndex 传入要查看的分页索引，从1开始
     * @return 返回分页结果，包含分页内容以及分页信息
     */
    public PageResult<TourActivity> findAllActivityWillHold(int pageIndex){

        //从数据库中找出所有的等待举办的活动
        //排序顺序对象
        Sort.Order order = new Sort.Order(Sort.Direction.ASC,"holdDate");
        //排序对象
        Sort sort = new Sort(order);
        //page:index是从0开始的，不是从1开始的
        Pageable pageable = new PageRequest(pageIndex-1,tourDreamProperties.getPageSize(),sort);

        /**
         *  root: 我们要查询的类型(TourActivity)
         *  query: 添加查询条件
         *  cb： 构建Predicate
         */
        Specification<TourActivity> specification = new Specification<TourActivity>() {
            @Override
            public Predicate toPredicate(Root<TourActivity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                //构建查询条件成功
                Path path = root.get("activityStatus");
                return  criteriaBuilder.equal(path,ActivityStatusEnum.WAIT_HOLD);
            }
        };
        //获取分页
        Page<TourActivity> tourActivityPage = tourActivityRepository.findAll(specification,pageable);

        //返回自定义的分页（自定义方便用于Android端）
        return PageResultUtils.getTourActivityPageResult(tourActivityPage);
    }

    /**
     * 将活动参与者添加到参与者数据库中
     * @param participant 需要参与者的基本信息，包括id和account
     */
    @Transactional
    public void participateActivity(Participant participant){

        //查看该用户是否已经申请参加该活动
        //获取活动信息
        TourActivity tourActivity = tourActivityRepository.findOne(participant.getId());
        //获取活动的参与者
        Set<Participant> participants = tourActivity.getParticipants();
        //活动中是否已经有了该参与者
        for (Participant participant2:
                participants) {
        }
        if (participants.contains(participant)){
            //抛出异常导致参加该活动失败
            throw new TourDreamException(ExceptionEnum.HAS_PARTICIPATE_THIS_ACTIVITY);
        }

        //如果是该活动的举办者，也不能再选择申请参加该活动
        //获取活动的举办者
        MyUser user = tourActivity.getHolder();
        if (user.getAccount().equals(participant.getAccount())){
            //举办者不能参加该活动
            throw new  TourDreamException(ExceptionEnum.HOLDER_CANT_PARTICIPATE);
        }

        //设置参与状态为“等待审核”
        participant.setJoinStatus(JoinStatusEnum.WAIT_AUDIT);
        //将活动参与者添加入该活动
        participantRepository.save(participant);

        return;
    }

}
