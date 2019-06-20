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
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.v5ent.entity.Block;
import com.v5ent.entity.ReturnLatest;

import net.matthew.Static_Value;
/**
 * 
 * @author 浙-大-基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计
 * 
 *
 */
@Controller
public class BankController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	public static final String API_URL_GETLATEST = "http://localhost:8080/getlatest";
	public static final String API_URL_GETALL = "http://localhost:8080/getAll";
	public static final String API_URL_ADDBLOCK = "http://localhost:8080/addBlock";
	private static DefaultHttpClient client = new DefaultHttpClient();

	final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	ModelAndView errorModelAndView = new ModelAndView();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index");
		return modelAndView;

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	ModelAndView trans(HttpServletRequest request) {
		HttpPost httpPost = null;
		String account = request.getParameter("account");
		String amount = request.getParameter("amount");
		String transtype = request.getParameter("type");
		String user = request.getParameter("user");
		String direction = "to";
		if (transtype.equals("In")) {
			direction = "from";
		}
		String logValue = transtype + ": " + amount + " " + direction + "  " + account;
		ModelAndView modelAndView;
		try {
			URIBuilder uriBuilder = new URIBuilder(API_URL_ADDBLOCK);
			List<NameValuePair> list = new LinkedList<>();
			BasicNameValuePair param1 = new BasicNameValuePair("user", user);
			BasicNameValuePair param2 = new BasicNameValuePair("type", Static_Value.TYPE_BANK);
			BasicNameValuePair param3 = new BasicNameValuePair("vac", logValue);
			list.add(param1);
			list.add(param2);
			list.add(param3);
			uriBuilder.addParameters(list);
			httpPost = new HttpPost(uriBuilder.build());
			HttpResponse response = client.execute(httpPost);
			response.addHeader("content-type", "application/json");
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			modelAndView = new ModelAndView();
			modelAndView.setViewName("/index");
			modelAndView.addObject("result", "Transfer success");
			return modelAndView;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return errorModelAndView;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return errorModelAndView;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return errorModelAndView;
		}
		
	}

}