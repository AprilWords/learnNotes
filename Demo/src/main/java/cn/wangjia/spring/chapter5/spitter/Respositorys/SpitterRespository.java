package cn.wangjia.spring.chapter5.spitter.Respositorys;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/28
 */
public interface SpitterRespository {
    void save(Spitter spitter);
    Spitter findByUserName(String userName);
}
