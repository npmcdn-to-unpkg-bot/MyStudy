package com.forsrc.base.service;


import com.forsrc.base.dao.BaseHibernateDao;
import com.forsrc.exception.DaoException;
import com.forsrc.exception.ServiceException;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public interface BaseService<E, PK extends Serializable> {
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<E> list(int start, int size) throws ServiceException;

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public E get(PK pk) throws ServiceException;

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public E load(PK pk) throws ServiceException;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
    public E save(E user) throws ServiceException;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
    public E update(E user) throws ServiceException, HibernateOptimisticLockingFailureException;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
    public E merge(E user) throws ServiceException, HibernateOptimisticLockingFailureException;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
    public void delete(E e) throws ServiceException;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
    public void clean();

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
    public void flush();


    public BaseHibernateDao<E, PK> getBaseHibernateDao();

    //public void setBaseHibernateDao(BaseHibernateDao<E, PK> baseHibernateDao);

}