package com.entity.model;

import com.entity.JianliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 简历
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-12-08 13:41:23
 */
public class JianliModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 年龄
	 */
	
	private String nianling;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 邮箱
	 */
	
	private String youxiang;
		
	/**
	 * 专业
	 */
	
	private String zhuanye;
		
	/**
	 * 学历
	 */
	
	private String xueli;
		
	/**
	 * 学校
	 */
	
	private String xuexiao;
		
	/**
	 * 所获奖项
	 */
	
	private String suohuojiangxiang;
		
	/**
	 * 所获技能
	 */
	
	private String suohuojineng;
		
	/**
	 * 在校经历
	 */
	
	private String zaixiaojingli;
		
	/**
	 * 自我评价
	 */
	
	private String ziwopingjia;
		
	/**
	 * 社会实践
	 */
	
	private String shehuishijian;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：邮箱
	 */
	 
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	
	/**
	 * 获取：邮箱
	 */
	public String getYouxiang() {
		return youxiang;
	}
				
	
	/**
	 * 设置：专业
	 */
	 
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	
	/**
	 * 获取：专业
	 */
	public String getZhuanye() {
		return zhuanye;
	}
				
	
	/**
	 * 设置：学历
	 */
	 
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	
	/**
	 * 获取：学历
	 */
	public String getXueli() {
		return xueli;
	}
				
	
	/**
	 * 设置：学校
	 */
	 
	public void setXuexiao(String xuexiao) {
		this.xuexiao = xuexiao;
	}
	
	/**
	 * 获取：学校
	 */
	public String getXuexiao() {
		return xuexiao;
	}
				
	
	/**
	 * 设置：所获奖项
	 */
	 
	public void setSuohuojiangxiang(String suohuojiangxiang) {
		this.suohuojiangxiang = suohuojiangxiang;
	}
	
	/**
	 * 获取：所获奖项
	 */
	public String getSuohuojiangxiang() {
		return suohuojiangxiang;
	}
				
	
	/**
	 * 设置：所获技能
	 */
	 
	public void setSuohuojineng(String suohuojineng) {
		this.suohuojineng = suohuojineng;
	}
	
	/**
	 * 获取：所获技能
	 */
	public String getSuohuojineng() {
		return suohuojineng;
	}
				
	
	/**
	 * 设置：在校经历
	 */
	 
	public void setZaixiaojingli(String zaixiaojingli) {
		this.zaixiaojingli = zaixiaojingli;
	}
	
	/**
	 * 获取：在校经历
	 */
	public String getZaixiaojingli() {
		return zaixiaojingli;
	}
				
	
	/**
	 * 设置：自我评价
	 */
	 
	public void setZiwopingjia(String ziwopingjia) {
		this.ziwopingjia = ziwopingjia;
	}
	
	/**
	 * 获取：自我评价
	 */
	public String getZiwopingjia() {
		return ziwopingjia;
	}
				
	
	/**
	 * 设置：社会实践
	 */
	 
	public void setShehuishijian(String shehuishijian) {
		this.shehuishijian = shehuishijian;
	}
	
	/**
	 * 获取：社会实践
	 */
	public String getShehuishijian() {
		return shehuishijian;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
			
}
