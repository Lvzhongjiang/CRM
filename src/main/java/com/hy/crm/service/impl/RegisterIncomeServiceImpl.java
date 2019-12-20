package com.hy.crm.service.impl;

import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.RegisterIncome;
import com.hy.crm.mapper.RegisterIncomeMapper;
import com.hy.crm.service.IRegisterIncomeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class RegisterIncomeServiceImpl extends ServiceImpl<RegisterIncomeMapper, RegisterIncome> implements IRegisterIncomeService {
    @Autowired
    private RegisterIncomeMapper registerIncomeMapper;

    @Override
    public ContractManagement contId(String contName) {
        return registerIncomeMapper.contName(contName);
    }

    @Override
    public void saveR(RegisterIncome registerIncome) {
        registerIncomeMapper.save(registerIncome);
    }
}
