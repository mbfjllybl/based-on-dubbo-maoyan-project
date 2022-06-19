package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.persistence.dao.MoocUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Service(interfaceClass = UserAPI.class)
public class UserServiceImpl implements UserAPI {

    @Autowired
    private MoocUserTMapper moocUserTMapper;

    @Override
    public int login(String username, String password) {
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(username);
        MoocUserT result = moocUserTMapper.selectOne(moocUserT);

        if (result != null && result.getUuid() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (result.getUserPwd().equals(md5Password)) {
                return result.getUuid();
            }
        }
        return 0;
    }

    @Override
    public boolean register(UserModel userModel) {

        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setAddress(userModel.getUsername());
        moocUserT.setUserPwd(MD5Util.encrypt(userModel.getPassword()));
        moocUserT.setEmail(userModel.getEmail());
        moocUserT.setAddress(userModel.getAddress());
        moocUserT.setUserPhone(userModel.getPhone());
        moocUserT.setUserName(userModel.getUsername());
        System.out.println(userModel.getUsername());
        Integer insert = moocUserTMapper.insert(moocUserT);
        if (insert > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkUsername(String username) {
        EntityWrapper<MoocUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", username);
        Integer result = moocUserTMapper.selectCount(entityWrapper);
        if (result != null && result > 0) {
            return false;
        } else {
            return true;
        }

    }

    private UserInfoModel do2UserInfo(MoocUserT moocUserT) {
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setUsername(moocUserT.getUserName());
        userInfoModel.setAddress(moocUserT.getAddress());
        userInfoModel.setUpdateTime(moocUserT.getUpdateTime().getTime());
        userInfoModel.setSex(moocUserT.getUserSex());
        userInfoModel.setUpdateTime(moocUserT.getUpdateTime().getTime());
        userInfoModel.setNickname(moocUserT.getNickName());
        userInfoModel.setBiography(moocUserT.getBiography());
        userInfoModel.setLifeState("" + moocUserT.getLifeState());
        userInfoModel.setHeadAddress(moocUserT.getAddress());
        userInfoModel.setPhone(moocUserT.getUserPhone());
        userInfoModel.setBeginTime(moocUserT.getBeginTime().getTime());
        userInfoModel.setBirthday(moocUserT.getBirthday());
        return userInfoModel;
    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        MoocUserT moocUserT = moocUserTMapper.selectById(uuid);
        UserInfoModel userInfoModel = do2UserInfo(moocUserT);
        return userInfoModel;
    }

    private Date time2Date(long time) {
        return new Date(time);
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        // 将传入的参数转换为DO 【MoocUserT】
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUuid(userInfoModel.getUuid());
        moocUserT.setNickName(userInfoModel.getNickname());
        moocUserT.setLifeState(Integer.parseInt(userInfoModel.getLifeState()));
        moocUserT.setBirthday(userInfoModel.getBirthday());
        moocUserT.setBiography(userInfoModel.getBiography());
//        moocUserT.setBeginTime(time2Date(userInfoModel.getBeginTime()));
        moocUserT.setHeadUrl(userInfoModel.getHeadAddress());
        moocUserT.setEmail(userInfoModel.getEmail());
        moocUserT.setAddress(userInfoModel.getAddress());
        moocUserT.setUserPhone(userInfoModel.getPhone());
        moocUserT.setUserSex(userInfoModel.getSex());
//        moocUserT.setUpdateTime(time2Date(userInfoModel.getUpdateTime()));

        // DO存入数据库
        Integer integer = moocUserTMapper.updateById(moocUserT);
        if(integer>0){
            // 将数据从数据库中读取出来
            UserInfoModel userInfo = getUserInfo(moocUserT.getUuid());
            // 将结果返回给前端
            return userInfo;
        }else{
            return null;
        }
    }
}
