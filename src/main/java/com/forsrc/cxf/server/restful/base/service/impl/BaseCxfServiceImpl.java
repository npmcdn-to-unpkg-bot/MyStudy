package com.forsrc.cxf.server.restful.base.service.impl;


import com.forsrc.cxf.server.restful.base.dao.BaseCxfDao;
import com.forsrc.cxf.server.restful.base.service.BaseCxfService;
import com.forsrc.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service(value = "baseCxfService")
@Transactional
public class BaseCxfServiceImpl<E, PK extends Serializable> implements BaseCxfService<E, PK> {

    @Autowired
    private BaseCxfDao baseCxfDao;

    @Override
    public <E> List<E> list(Class<E> cls, Integer start, Integer size) throws ServiceException {
        return getBaseCxfDao().list(cls, start, size);
    }

    @Override
    public <E, PK extends Serializable> E get(Class<E> cls, PK pk) throws ServiceException {
        return getBaseCxfDao().get(cls, pk);
    }

    @Override
    public <E> int count(Class<E> cls) throws ServiceException {
        return getBaseCxfDao().count(cls);
    }

    @Override
    public <E, PK extends Serializable> E load(Class<E> cls, PK pk) throws ServiceException {
        return getBaseCxfDao().load(cls, pk);
    }

    @Override
    public <E> E save(E e) throws ServiceException {
        return getBaseCxfDao().save(e);
    }

    @Override
    public <E> E update(E e) throws ServiceException, HibernateOptimisticLockingFailureException {
        return getBaseCxfDao().update(e);
    }

    @Override
    public <E> E merge(E e) throws ServiceException, HibernateOptimisticLockingFailureException {
        return getBaseCxfDao().merge(e);
    }

    @Override
    public <E> void delete(E e) throws ServiceException {
        getBaseCxfDao().delete(e);
    }

    @Override
    public void clean() {
        getBaseCxfDao().clean();
    }

    @Override
    public void flush() {
        getBaseCxfDao().flush();
    }

    public BaseCxfDao getBaseCxfDao() {
        return baseCxfDao;
    }

    public void setBaseCxfDao(BaseCxfDao baseCxfDao) {
        this.baseCxfDao = baseCxfDao;
    }
}
