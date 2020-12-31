package com.chen.sportplatform.dao;

import com.chen.sportplatform.entity.MainMenu;
import com.chen.sportplatform.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
