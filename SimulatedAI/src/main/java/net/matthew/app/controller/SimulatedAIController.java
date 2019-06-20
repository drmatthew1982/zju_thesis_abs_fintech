package net.matthew.app.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计 ZJU
 *
 * 
 *
 */
@Controller
public class SimulatedAIController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	public static String DEBT = "10";
	public static String ROE = "1";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index");
		modelAndView.addObject("debt", DEBT);
		modelAndView.addObject("roe", ROE);
		return modelAndView;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	ModelAndView update(HttpServletRequest httprequest, HttpServletResponse httpresponse) {
		String debt = httprequest.getParameter("debt");
		String roe = httprequest.getParameter("roe");
		DEBT = debt;
		ROE = roe;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index");
		modelAndView.addObject("debt", DEBT);
		modelAndView.addObject("roe", ROE);
		modelAndView.addObject("result", "Update Sucessed");
		return modelAndView;
	}

	@RequestMapping(value = "/getDebtAndRoe", method = RequestMethod.GET)
	@ResponseBody
	String getDebtAndRoe(HttpServletRequest httprequest, HttpServletResponse httpresponse) {
		return DEBT+","+ROE;
	}

}