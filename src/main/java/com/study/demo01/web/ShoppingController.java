package com.study.demo01.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.study.demo01.pojo.Goods;
import com.study.demo01.pojo.ShoppingCart;
import com.study.demo01.pojo.Student;
import com.study.demo01.service.IShoppingService;
import com.study.demo01.util.AlipayConfig;

@RestController
@RequestMapping("/shop")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class ShoppingController {
	@Autowired
	private IShoppingService shoppingService;
	@RequestMapping("/goodslistmain")
	public List<Goods> goodsListMain() {
		return shoppingService.listAllGoods();
	}
	@RequestMapping("/querygoods")
	public Goods queryGoodsById(Integer goodsId) {
		return shoppingService.queryGoodsById(goodsId);
	}
	@RequestMapping("login")
	public Student login(@RequestBody Student student,HttpSession session) {
		student=shoppingService.verifyStudentByLoginAndPasswd(student.getStuLogin(), student.getStuPasswd());
		session.setAttribute("student", student);
		return student;
	}
	@RequestMapping("/addtocart")
	public Boolean addGoodsToShopingCart(ShoppingCart shoppingCart,Goods goods,HttpSession session) {
		Student student=(Student)session.getAttribute("student");
		shoppingCart.setGoods(goods);
		if (student!=null ) {
			shoppingCart.setStudentId(student.getStuId());
			return shoppingService.addGoodsToShopingCart(shoppingCart);
		}
		return false;
	}
	@RequestMapping("/goodslistbystuid")
	public List<ShoppingCart> getGoodsListByStuId(Integer stuId){
		return shoppingService.listGoodsListByStuId(stuId);
	}
	@RequestMapping("/deleteshoppingcart")
	public Boolean deleteShoppingCartByCartId(int cartId){
		return shoppingService.deleteShoppingCartByCartId(cartId);
	}
	@RequestMapping("/deletegoodsselected")
	public Boolean deleteShoppingCartByCartIds(Integer[] ids){
		return shoppingService.deleteShoppingCartByCartIds(ids);
	}
	@RequestMapping("/pay")
	public String pay(HttpServletRequest request) {
		//请求
		String result="";
		try {
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			
			//设置请求参数
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
			alipayRequest.setReturnUrl(AlipayConfig.return_url);
			alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
			
			//商户订单号，商户网站订单系统中唯一订单号，必填
			String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//付款金额，必填
			String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
			//订单名称，必填
			String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
			//商品描述，可空
			String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+ "\"total_amount\":\""+ total_amount +"\"," 
					+ "\"subject\":\""+ subject +"\"," 
					+ "\"body\":\""+ body +"\"," 
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			
			//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
			//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
			//		+ "\"total_amount\":\""+ total_amount +"\"," 
			//		+ "\"subject\":\""+ subject +"\"," 
			//		+ "\"body\":\""+ body +"\"," 
			//		+ "\"timeout_express\":\"10m\"," 
			//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
			
			//请求
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
}
