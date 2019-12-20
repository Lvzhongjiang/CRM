package com.hy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.ContractManagement;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IContractManagementService extends IService<ContractManagement> {
    public IPage<ContractManagement> queryPage(String status,String heTong, String keyword, Integer pageNum, Integer size);
    public ContractManagement queryName(String contName);
    public Integer listZx();
    public Integer listYg();
    public Integer listYc();
    public Integer listYz();
    public Integer listBenZhou();
    public Integer listShangZhou();
    public Integer listBenYue();
    public Integer listShangYue();
    public Integer listBenJiDu();
    public Integer listShangJiDu();
}
