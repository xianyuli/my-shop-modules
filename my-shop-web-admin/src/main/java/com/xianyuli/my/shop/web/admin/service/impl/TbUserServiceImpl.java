package com.xianyuli.my.shop.web.admin.service.impl;

import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.admin.dao.TbUserDao;
import com.xianyuli.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: my-shop-modules
 * @Package: com.xianyuli.my.shop.web.admin.service.impl
 * @ClassName: TbuserServiceImpl
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/10/22 0022 23:55
 * @UpdateUser: LW
 * @UpdateDate: 2018/10/22 0022 23:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired(required = false)
    TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public void insert(TbUser tbUser) {
        tbUserDao.insert(tbUser);
    }

    @Override
    public void delete(long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> selectByUsername(String username) {
        return tbUserDao.selectByUsername(username);
    }
}
