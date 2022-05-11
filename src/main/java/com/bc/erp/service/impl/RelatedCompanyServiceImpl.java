package com.bc.erp.service.impl;

import com.bc.erp.entity.RelatedCompany;
import com.bc.erp.entity.RelatedCompanyAccount;
import com.bc.erp.entity.RelatedCompanyContact;
import com.bc.erp.mapper.RelatedCompanyAccountMapper;
import com.bc.erp.mapper.RelatedCompanyContactMapper;
import com.bc.erp.mapper.RelatedCompanyMapper;
import com.bc.erp.service.RelatedCompanyService;
import com.bc.erp.utils.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 往来单位
 *
 * @author zhou
 */
@Service("relatedCompanyService")
public class RelatedCompanyServiceImpl implements RelatedCompanyService {

    @Resource
    RelatedCompanyMapper relatedCompanyMapper;

    @Resource
    RelatedCompanyContactMapper relatedCompanyContactMapper;

    @Resource
    RelatedCompanyAccountMapper relatedCompanyAccountMapper;

    /**
     * 获取往来单位列表
     *
     * @param paramMap 参数map
     * @return 往来单位列表
     */
    @Override
    public List<RelatedCompany> getRelatedCompanyList(Map<String, Object> paramMap) {
        return relatedCompanyMapper.getRelatedCompanyList(paramMap);
    }

    /**
     * 获取往来单位分页信息
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 往来单位分页信息
     */
    @Override
    public PageInfo<RelatedCompany> getRelatedCompanyPageInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RelatedCompany> relatedCompanyList = relatedCompanyMapper.getRelatedCompanyList(paramMap);
        return new PageInfo<>(relatedCompanyList);
    }

    /**
     * 新增往来单位
     *
     * @param relatedCompany 往来单位
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRelatedCompany(RelatedCompany relatedCompany) {
        relatedCompanyMapper.addRelatedCompany(relatedCompany);

        // 联系人
        List<RelatedCompanyContact> contactList = relatedCompany.getRelatedCompanyContactList();
        if (!CollectionUtils.isEmpty(contactList)) {
            for (RelatedCompanyContact contact : contactList) {
                contact.setId(CommonUtil.generateId());
                contact.setEnterpriseId(relatedCompany.getEnterpriseId());
                contact.setRcId(relatedCompany.getId());
                contact.setCreateId(relatedCompany.getCreateId());
            }
            relatedCompanyContactMapper.addRelatedCompanyContactList(contactList);
        }
        // 账户
        List<RelatedCompanyAccount> accountList = relatedCompany.getRelatedCompanyAccountList();
        if (!CollectionUtils.isEmpty(accountList)) {
            for (RelatedCompanyAccount account : accountList) {
                account.setId(CommonUtil.generateId());
                account.setEnterpriseId(relatedCompany.getEnterpriseId());
                account.setRcId(relatedCompany.getId());
                account.setCreateId(relatedCompany.getCreateId());
            }
            relatedCompanyAccountMapper.addRelatedCompanyAccountList(accountList);
        }

    }

    /**
     * 更新往来单位
     *
     * @param relatedCompany 往来单位
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRelatedCompany(RelatedCompany relatedCompany) {
        relatedCompanyMapper.updateRelatedCompany(relatedCompany);

        // 联系人
        List<RelatedCompanyContact> contactList = relatedCompany.getRelatedCompanyContactList();
        List<RelatedCompanyContact> addContactList = new ArrayList<>();
        List<RelatedCompanyContact> updateContactList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(contactList)) {
            for (RelatedCompanyContact contact : contactList) {
                if (StringUtils.isEmpty(contact.getId())) {
                    contact.setId(CommonUtil.generateId());
                    contact.setEnterpriseId(relatedCompany.getEnterpriseId());
                    addContactList.add(contact);
                } else {
                    updateContactList.add(contact);
                }
            }
        }
        if (!CollectionUtils.isEmpty(addContactList)) {
            relatedCompanyContactMapper.addRelatedCompanyContactList(addContactList);
        }
        if (!CollectionUtils.isEmpty(updateContactList)) {
            relatedCompanyContactMapper.updateRelatedCompanyContactList(updateContactList);
        }

        // 账户
        List<RelatedCompanyAccount> accountList = relatedCompany.getRelatedCompanyAccountList();
        List<RelatedCompanyAccount> addAccountList = new ArrayList<>();
        List<RelatedCompanyAccount> updateAccountList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(accountList)) {
            for (RelatedCompanyAccount account : accountList) {
                if (StringUtils.isEmpty(account.getId())) {
                    account.setId(CommonUtil.generateId());
                    account.setEnterpriseId(CommonUtil.generateId());
                    addAccountList.add(account);
                } else {
                    updateAccountList.add(account);
                }
            }
        }
        if (!CollectionUtils.isEmpty(addAccountList)) {
            relatedCompanyAccountMapper.addRelatedCompanyAccountList(addAccountList);
        }
        if (!CollectionUtils.isEmpty(updateAccountList)) {
            relatedCompanyAccountMapper.updateRelatedCompanyAccountList(updateAccountList);
        }

    }

    /**
     * 根据主键获取往来单位
     *
     * @param id 主键
     * @return 往来单位
     */
    @Override
    public RelatedCompany getRelatedCompanyById(String id) {
        return relatedCompanyMapper.getRelatedCompanyById(id);
    }

}