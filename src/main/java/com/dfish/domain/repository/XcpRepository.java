package com.dfish.domain.repository;

import com.dfish.domain.entity.Xuanchuanpin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
@Repository
public interface XcpRepository extends JpaRepository<Xuanchuanpin,Long>{

    @Query(value="select * from Xuanchuanpin a where title like ?1 and makestyle like ?2  and common_advise like ?3",nativeQuery=true)
    List<Xuanchuanpin> findbytitle(String title,String makestyle,String commonAdvise);
}
//    totalPrice (BETWEEN minprice like ?3 and maxprice like ?4
//and  ?3 <= totalPrice and ?4 >= totalPrice