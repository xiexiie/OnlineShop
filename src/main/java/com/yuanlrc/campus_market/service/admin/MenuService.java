package com.yuanlrc.campus_market.service.admin;

/**
 * 后台菜单操作service
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanlrc.campus_market.dao.admin.MenuDao;
import com.yuanlrc.campus_market.entity.admin.Menu;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	/**
	 * 菜单添加/编辑
	 */
	public Menu save(Menu menu){
		return menuDao.save(menu);
	}
	
	/**
	 * 获取所有的菜单列表
	 */
	public List<Menu> findAll(){
		return menuDao.findAll();
	}
	
	/**
	 * 根据id查询菜单
	 */
	public Menu find(Long id){
		return menuDao.find(id);
	}
	
	/**
	 * 根据id删除一条记录
	 */
	public void delete(Long id){
		menuDao.deleteById(id);
	}
}
