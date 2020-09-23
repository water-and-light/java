package com.study.demo01.web;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.study.demo01.pojo.Goods;
import com.study.demo01.pojo.GoodsType;
import com.study.demo01.service.ICardService;

import io.minio.MinioClient;

@RestController
@RequestMapping("/card")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class GoodsController {
	@Autowired
	private ICardService cardService;
	@RequestMapping("/goodslistmain")
	public List<Goods> goodsListMain() {
		return cardService.listAllGoods();
	}
	@RequestMapping("/querygoods")
	public Goods queryGoodsById(Integer goodsId) {
		return cardService.queryGoodsById(goodsId);
	}
	@RequestMapping("/savegoods")
	public Boolean saveGoods(Goods goods,MultipartFile file) {
		System.out.println(goods);
		if (file.getSize()==0 || file.isEmpty()) {
			goods.setGoodsImage("");
		} else {
			try {
				System.out.println(file.getOriginalFilename());
				MinioClient minoClient=new MinioClient("http://127.0.0.1:9000", "minioadmin", "minioadmin");
				if (!minoClient.bucketExists("goods")) {
					minoClient.makeBucket("goods");
				}
				String fileName=file.getOriginalFilename();
				String newName =UUID.randomUUID().toString().replace("-", "")+fileName.substring(fileName.lastIndexOf("."));
				InputStream inputStream=file.getInputStream();
				minoClient.putObject("goods", newName, inputStream,"image/png");
				inputStream.close();
				String url=minoClient.getObjectUrl("goods", newName);
				goods.setGoodsImage(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ( goods.getGoodsId()== null) {  //新增
			return cardService.addGoodsSelective(goods);
		} else {
			return cardService.updateGoods(goods);
		}
	}
	@RequestMapping("deletegoods")
	public Boolean deleteGoods(Integer goodsId) {
		return cardService.deleteGoodsById(goodsId);
	}
	@RequestMapping("deletegoodsselected")
	public Boolean deleteGoodsSelected(Integer[] ids) {
		Arrays.stream(ids).forEach(System.out::println);
		return cardService.deleteGoodsSelected(ids);
	}
	@RequestMapping("listGoodsByNameOrPrice")
	public List<Goods> listGoodsByNameOrPrice(String condition) {
		return cardService.listGoodsByNameOrPrice(condition);
	}
	@RequestMapping("getgoodstypelist")
	public List<GoodsType> listAllGoodsTypes(){
		return cardService.listAllGoodsTypes();
	}
}
