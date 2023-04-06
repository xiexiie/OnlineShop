package com.yuanlrc.campus_market.dao.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yuanlrc.campus_market.entity.common.Student;
import com.yuanlrc.campus_market.entity.common.WantedGoods;

/**
 * 求购物品dao层
 */

@Repository
public interface WantedGoodsDao extends JpaRepository<WantedGoods, Long>,JpaSpecificationExecutor<WantedGoods>{
	
	/**
	 * 根据id获取
	 */
	@Query("select wg from WantedGoods wg where id = :id")
	WantedGoods find(@Param("id")Long id);
	
	/**
	 * 根据学生信息查询
	 */
	public List<WantedGoods> findByStudent(Student student);
}
