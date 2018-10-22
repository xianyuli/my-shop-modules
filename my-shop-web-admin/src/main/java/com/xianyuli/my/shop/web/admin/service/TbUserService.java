package com.xianyuli.my.shop.web.admin.service;

import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.admin.dao.TbUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: my-shop-modules
 * @Package: com.xianyuli.my.shop.web.admin.service
 * @ClassName: TbUserService
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/10/22 0022 23:52
 * @UpdateUser: LW
 * @UpdateDate: 2018/10/22 0022 23:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface TbUserService {

    /**
     * 查询全部用户信息
     * @return
     */
    public List<TbUser> selectAll();


}
