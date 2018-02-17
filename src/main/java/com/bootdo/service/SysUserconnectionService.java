package com.bootdo.service;

import com.bootdo.common.service.CrudService;
import com.bootdo.domain.entity.SysUserconnection;
import com.bootdo.domain.entity.example.SysUserconnectionExample;
import com.bootdo.domain.mapper.SysUserconnectionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kits
 * @version 0.0.1
 * @date 2017/11/30
 * @time 07:01
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
public class SysUserconnectionService  extends CrudService<SysUserconnectionMapper,SysUserconnection,SysUserconnectionExample> {

    public SysUserconnection getUserconnectionByProviderUserIdAndProviderId(String providerUserId, String providerId) {
        SysUserconnectionExample hyUserconnectionExample = new SysUserconnectionExample();
        hyUserconnectionExample.createCriteria().andProvideridEqualTo(providerId).andProvideruseridEqualTo(providerUserId);
        List<SysUserconnection> list = dao.selectByExample(hyUserconnectionExample);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
