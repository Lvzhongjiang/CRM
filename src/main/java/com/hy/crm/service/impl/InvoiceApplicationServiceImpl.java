package com.hy.crm.service.impl;

import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.InvoiceApplication;
import com.hy.crm.mapper.InvoiceApplicationMapper;
import com.hy.crm.service.IInvoiceApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class InvoiceApplicationServiceImpl extends ServiceImpl<InvoiceApplicationMapper, InvoiceApplication> implements IInvoiceApplicationService {
    @Autowired
    private InvoiceApplicationMapper invoiceApplicationMapper;

    @Override
    public ContractManagement contId(String contName) {
        return invoiceApplicationMapper.contName(contName);
    }

    @Override
    public void saveInvoice(InvoiceApplication invoiceApplication) {
        invoiceApplicationMapper.saveInvoice(invoiceApplication);
    }

}
