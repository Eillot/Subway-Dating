package com.simon.subwaydating.facade.constants;

/**
 * @version: java version 1.7+
 * @Author : Simon
 * @Explain :
 * @contact:
 * @Time : 2018/8/28 17:50
 * @File : RegexpConstant
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class RegexpConstant {

    public interface SUBMIT{}//提交(必填,验证)
    public interface MODIFY{}//暂存、修改(非必填,需验证)
    public interface DELETE{}//删除
    public interface QUERY{}//列表
    public interface SPECIALOPERATE{}//特殊操作

}
