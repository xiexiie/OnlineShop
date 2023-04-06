package com.yuanlrc.campus_market.service.common;

/**
 * 学生信息操作service
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.yuanlrc.campus_market.bean.PageBean;
import com.yuanlrc.campus_market.dao.common.StudentDao;
import com.yuanlrc.campus_market.entity.common.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	/**
	 * 根据学号查询
	 */
	public Student findBySn(String sn){
		return studentDao.findBySn(sn);
	}
	
	/**
	 * 根据id查找
	 */
	public Student findById(Long id){
		return studentDao.find(id);
	}
	
	/**
	 * 学生修改/编辑，当传入id时则为编辑，若id为空则为添加
	 */
	public Student save(Student student){
		return studentDao.save(student);
	}
	
	/**
	 * 搜索学生列表
	 */
	public PageBean<Student> findlist(PageBean<Student> pageBean,Student student){
		ExampleMatcher exampleMatcher = ExampleMatcher.matching();
		exampleMatcher = exampleMatcher.withMatcher("sn", GenericPropertyMatchers.contains());
		exampleMatcher = exampleMatcher.withIgnorePaths("status");
		Example<Student> example = Example.of(student, exampleMatcher);
		Sort sort = Sort.by(Direction.DESC, "createTime");
		PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
		Page<Student> findAll = studentDao.findAll(example, pageable);
		pageBean.setContent(findAll.getContent());
		pageBean.setTotal(findAll.getTotalElements());
		pageBean.setTotalPage(findAll.getTotalPages());
		return pageBean;
	}
	
	/**
	 * 根据id删除
	 */
	public void delete(Long id){
		studentDao.deleteById(id);
	}
	
	/**
	 * 获取学生总数
	 */
	public long total(){
		return studentDao.count();
	}
}
