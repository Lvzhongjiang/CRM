package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.mapper.ContractManagementMapper;
import com.hy.crm.service.IContractManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class ContractManagementServiceImpl extends ServiceImpl<ContractManagementMapper, ContractManagement> implements IContractManagementService {
    @Autowired
    private ContractManagementMapper contractManagementMapper;

    public IPage<ContractManagement> queryPage(String status,String heTong, String keyword,Integer pageNum, Integer size) {
        Page<ContractManagement> page = new Page<>(pageNum,size);
        page.setRecords(contractManagementMapper.queryAll(status,heTong,keyword,page));
        return page;
    }

    @Override
    public ContractManagement queryName(String contName) {
        return contractManagementMapper.contName(contName);
    }

    @Override
    public Integer listZx() {
        return contractManagementMapper.listZx();
    }

    @Override
    public Integer listYg() {
        return contractManagementMapper.listYg();
    }

    @Override
    public Integer listYc() {
        return contractManagementMapper.listYc();
    }

    @Override
    public Integer listYz() {
        return contractManagementMapper.listYz();
    }

    @Override
    public Integer listBenZhou() {
        return contractManagementMapper.listBenZhou();
    }

    @Override
    public Integer listShangZhou() {
        return contractManagementMapper.listShangZhou();
    }

    @Override
    public Integer listBenYue() {
        return contractManagementMapper.listBenYue();
    }

    @Override
    public Integer listShangYue() {
        return contractManagementMapper.listShangYue();
    }

    @Override
    public Integer listBenJiDu() {
        return contractManagementMapper.listBenJiDu();
    }

    @Override
    public Integer listShangJiDu() {
        return contractManagementMapper.listShangJiDu();
    }
}
