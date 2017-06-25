package com.dfish.domain.repository;

import com.dfish.domain.entity.Xuanchuanmsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
@Repository
public interface XcxxRepository extends JpaRepository<Xuanchuanmsg,Long>{
//    @Query(value="select * from Xuanchuanmsg a where title = ?1",nativeQuery=true)
    @Query(value="select * from Xuanchuanmsg a where title like ?1",nativeQuery=true)
    List<Xuanchuanmsg> findbytitle(String title);

    @Query(value="select * from Xuanchuanmsg",nativeQuery=true)
    List<Xuanchuanmsg> findAllxcxx();

    @Query(value="select * from Xuanchuanmsg a where xcxxleibie =?1",nativeQuery=true)
    List<Xuanchuanmsg> findbyleibie(String xcxxleibie);
//    select bean from User bean where bean.org.parent.id=?1 and bean.group.id=?2")
    //多重查询
//    @Query(value="select * from Xuanchuanmsg a where title like ?1 ,applytime like ?2 and xcleibie like?3",nativeQuery=true)
    @Query(value="select * from Xuanchuanmsg a where title like ?1 and applytime like ?2  and xcxxleibie like?3 and ispass like?4 ",nativeQuery=true)
    public List<Xuanchuanmsg> findByOrgIdAndGroupId(String title, String applytime,String xcxxleibie,String ispass);

    @Query(value="select * from Xuanchuanmsg a where xcxxleibie like ?1 and meijie like ?2 ",nativeQuery=true)
    List<Xuanchuanmsg> findBylbmj(String xcxxleibie, String meijie);

}
