package cn.wangjia.Proxy.Proxy.Cglib;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/5/24
 */
public class DoCGLib {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //通过生成子类的方式创建代理类
        Singer proxyImp = (Singer)proxy.getProxy(Singer.class);
        proxyImp.says("wnagjia");
    }
}
