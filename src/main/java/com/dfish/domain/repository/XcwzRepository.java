package com.dfish.domain.repository;

import com.dfish.domain.entity.Xuanchuanwzly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
@Repository
public interface XcwzRepository extends JpaRepository<Xuanchuanwzly,Long> {
    @Query(value="select * from Xuanchuanwzly a where title like ?1 and ispass like ?2",nativeQuery=true)
    List<Xuanchuanwzly> findbytitle(String title,String ispass);
}
