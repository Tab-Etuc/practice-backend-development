package tw.edu.ntub.imd.birc.practice.service.transformer;

import tw.edu.ntub.birc.common.util.JavaBeanUtils;

import javax.annotation.Nonnull;

public interface BeanEntityTransformer<B, E> {
    @Nonnull
    E transferToEntity(@Nonnull B b);

    @Nonnull
    B transferToBean(@Nonnull E e);

    default void updateEntity(@Nonnull B b, @Nonnull E e) {
        JavaBeanUtils.copy(b, e);
    }
}
