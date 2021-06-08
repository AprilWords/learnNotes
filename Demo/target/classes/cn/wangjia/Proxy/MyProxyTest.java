// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MyProxyTest.java

package cn.wangjia.Proxy;

import java.lang.reflect.*;
import java.util.Properties;

// Referenced classes of package cn.wangjia.Proxy:
//			IHello, MyInvocationHandler, Hello

public class MyProxyTest
{

	public MyProxyTest()
	{
	}

	public static void main(String args[])
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
	{
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Class proxyClazz = Proxy.getProxyClass(cn/wangjia/Proxy/IHello.getClassLoader(), new Class[] {
			cn/wangjia/Proxy/IHello
		});
		Constructor constructor = proxyClazz.getConstructor(new Class[] {
			java/lang/reflect/InvocationHandler
		});
		IHello iHello1 = (IHello)constructor.newInstance(new Object[] {
			new MyInvocationHandler(new Hello())
		});
		iHello1.sayHello();
		IHello iHello2 = (IHello)Proxy.newProxyInstance(cn/wangjia/Proxy/IHello.getClassLoader(), new Class[] {
			cn/wangjia/Proxy/IHello
		}, new MyInvocationHandler(new Hello()));
		iHello2.sayHello();
	}
}
