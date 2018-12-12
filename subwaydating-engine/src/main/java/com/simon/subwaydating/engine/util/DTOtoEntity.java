package com.simon.subwaydating.engine.util;

import com.simon.subwaydating.dao.domain.User;
import com.simon.subwaydating.facade.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain : DTO
 * @contact:
 * @Time : 2018/11/2 15:27
 * @File : DTOtoEntity
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class DTOtoEntity {

    /**
     * 将DTO数据传输对象属性映射为实体类属性
     */
    private static final Logger log=LoggerFactory.getLogger(DTOtoEntity.class);
    // 使用多线程安全的Map来缓存BeanCopier，由于读操作远大于写，所以性能影响可以忽略
    public static ConcurrentHashMap<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<String, BeanCopier>();

    /**
     * 通过cglib BeanCopier形式
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier = null;
        copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        // putIfAbsent已经实现原子操作了
        beanCopierMap.putIfAbsent(beanKey, copier);
        copier = beanCopierMap.get(beanKey);
        copier.copy(source, target, null);
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    /**
     ×通过常规反射形式
     * DTO对象转换为实体对象。如命名不规范或其他原因导致失败。
     * @param t 源转换的对象
     * @param e 目标转换的对象
     *
     */
    public static <T,E> void transalte(T t,E e){
        Method[] tms=t.getClass().getDeclaredMethods();
        Method[] tes=e.getClass().getDeclaredMethods();
        for(Method m1:tms){
            if(m1.getName().startsWith("get")){
                String mNameSubfix=m1.getName().substring(3);
                String forName="set"+mNameSubfix;
                for(Method m2:tes){
                    if(m2.getName().equals(forName)){
                        // 如果类型一致，或者m2的参数类型是m1的返回类型的父类或接口
                        boolean canContinue = m2.getParameterTypes()[0].isAssignableFrom(m1.getReturnType());
                        if (canContinue) {
                            try {
                                m2.invoke(e, m1.invoke(t));
                                break;
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                                // TODO Auto-generated catch block
                                log.debug("DTO to Entity转换失败");
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }

        }
        log.debug("转换完成");

    }

}
