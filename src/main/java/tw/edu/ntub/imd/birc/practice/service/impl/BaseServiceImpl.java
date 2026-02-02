package tw.edu.ntub.imd.birc.practice.service.impl;

import tw.edu.ntub.imd.birc.practice.databaseconfig.dao.BaseDAO;
import tw.edu.ntub.imd.birc.practice.service.BaseService;
import tw.edu.ntub.imd.birc.practice.service.transformer.BeanEntityTransformer;
import tw.edu.ntub.imd.birc.practice.exception.NotFoundException;

import java.io.Serializable;
import java.util.Optional;

public abstract class BaseServiceImpl<B, E, ID extends Serializable> extends BaseViewServiceImpl<B, E, ID>
        implements BaseService<B, ID> {
    private final BaseDAO<E, ID> baseDAO;

    public BaseServiceImpl(BaseDAO<E, ID> d, BeanEntityTransformer<B, E> transformer) {
        super(d, transformer);
        this.baseDAO = d;
    }

    @Override
    public B save(B b) {
        E entity = transformer.transferToEntity(b);
        return transformer.transferToBean(baseDAO.save(entity));
    }

    @Override
    public void update(ID id, B b) {
        Optional<E> optional = baseDAO.findById(id);
        if (optional.isPresent()) {
            E entity = optional.get();
            transformer.updateEntity(b, entity);
            baseDAO.update(entity);
        } else {
            throw new NotFoundException("找不到資料, id = " + id);
        }
    }

    @Override
    public void delete(ID id) {
        baseDAO.deleteById(id);
    }
}
