package com.study.demo01.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000116662687";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDFofmP4gQkU0L2IZCIZDobRLYLwicrZ0xlS9zdNPEfFHL0aBOTLigK1vlO2WkUBaEkEoYe47G0gyjs1flVUoRFFDFE1lZVNULWY5dVi3b4mpfVYIDqgKRmjchjUWdvnGShbswlExbCmBRKe3z2bsvf1Juj1oXo0QK1fuGGq/XIJt5rbG7CX0/Mw3u9nhvrjyO0kn72sb4089WqH7K9xMorSSQTG7NkVHZw1ouX87zz17NdU4YhYGFu1P+hecLxLcLSKtnkeRazJeSmnlhn5PrVqG9zRTYEg/3IlLSV6Kls9kZIhMFhjJcmtdNjcC9qxvdtysDYZxfPdDbKZuwPaPx3AgMBAAECggEBALqrA/pIA5t/3TZ3e3moGU4aN0yh5LdVSU5AOmvhjoHJoc6B40NYDFA4vqAgL+TOcGaO7ImOjRGv9N7GOEvDtdU9fk/DlyXCOdAfnxgYs5WbByBulzVnrmCDOKu+ftFnyZDFAyNdhVjlpfy36M8m1YAj46H7hN3jVQiywDeggnS5v1zuszSf6q4IAg8+2dCJAsGftUBwD+2ocZbutmCra/ka34EG5PPOtr+ANXLNkxT+O8AHBsHcKeXgaj8/LvdKPwdhta10OzEFPQ845IbIIxe6hTXmLAjCjtr3tesgQXgMRAzOyGZBqpUkYX5xUcTe6Qhu31ld0PYuAMqPy311n/ECgYEA9LyRCueHLL+L/7+0zvJZqYDu2MTe7gU9zHiZHbLoIRLC7bfI4O5LE+XnUbaQexa6jDWZojqrhrCWN71YM2j7n+cZiWglQocDH7oue4iNt8IxfOTOLDrGJfgGiiOye4k41h8NvR8oKOKFeICizAwLss2RXxtgFyW5AzyFcuKLmqkCgYEAzrpwzk4GfwMILjlrW5/a5b8NwwkztJ2AnWixn+ap30yldWvks9761E8c2LSQy5UKdPD3lAnUq8D+gAgfK11tqMckd15EEcFPgQshwQp7J901+QbsDVyM0RApyDAwi0d/K+2FAbMAUv4dZQb6O++budlbvMd/g399ca1qrD/Sch8CgYBlZe8uNmkiGCaYCsSN7YlKmlnbRA4dTdyh5+GAlYxpj41l0nyO/QvsLZfemiZYaT1XNCn4Nhi1EFrcsz1k531Bbg19icHOQ4P+1DPICPa2iOXaGi510tAgERgcide8KUl8JZeaoNsRvXCRUbKhmegK5/LwFbaFQKLb/WpJBCXVKQKBgCcOto1j1HpeukbxdkUjWJoblKAKtwgi0c/rndOWIvYbZw9eSSFquX0vTUXsJ4cvK4CYnk4L5XBl0C+kWS86QaOnrE4ZM0cffMPmtIPiVQ5dDvtzwVls6PX+1cYKxMEryu0jvQNrLF6BwE/8F38HcCaW2Gw8TO0tQygdGZBdpocFAoGAdiMfjcfbSZ2/NU1nkTeruAc2BT0usHVIXQh15Ym9gxAyTWCBiz/VN9XCfBzV0UJaZYM5LI3ssOPAjVJ6nG+WiVC3g4l19DRzjLINfW5aHuJrJqnaa/WV4aXLZXc3Mp7l6uS8Zmt9q6kLN70EMiMRbeCa693U/OIKxcw6NTYkM/I=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmoWzDkS/Nub11/Zt3wwooFO3NUOniVgtc4vB+BZVt0jYhFYwsMtuxqkPeWLwHHj0zZ7kidSBXF+bpNBV4t+Bp+msg5rzAvAsLWFgLE1Z+TXRzXgtaKW888x5B5QXDTdtyuReJtWQOKGPALNXuzZqnLYCOrk6pnGH/b5g5oPK28ZudSilT5cSupLbMc78IKRPwSSaPTs5WUNixwiMqgCgJyZ5VPEk/IN49j4nVqpJwm1SDNtUO7Kq2WZDnJB4WSEi16ouyUKq0dXgKNcnJPz7pjJh7r3MWKzjsQJ8a4iTDB6Y1zfVzTkdvj3heq9WHWF/Q2AQDDYLiB7aQaXxWPLEEwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

