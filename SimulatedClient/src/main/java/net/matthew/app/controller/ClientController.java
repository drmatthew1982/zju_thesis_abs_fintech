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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.v5ent.entity.Block;
import com.v5ent.entity.ReturnLatest;

@Controller
public class ClientController {
	  public static String API_URL = "http://localhost:8080/getlatest";
	  public static final String API_URL_GETALL = "http://localhost:8080/getAll";
	  private static DefaultHttpClient client = new DefaultHttpClient();
	  final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	  ModelAndView errorModelAndView = new ModelAndView();
	  
	  @RequestMapping("/")
      @ResponseBody
      ModelAndView home() {
		HttpGet httpGet=null;
    	//HttpResponse response;
		try {
			URIBuilder uriBuilder = new URIBuilder(API_URL);
			
	        List<NameValuePair> list = new LinkedList<>();
	        BasicNameValuePair param1 = new BasicNameValuePair("user", "client");
	        list.add(param1);
	        uriBuilder.addParameters(list);
	        httpGet = new HttpGet(uriBuilder.build());
	    	HttpResponse response = client.execute(httpGet);
			response.addHeader("content-type","application/json");
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			ReturnLatest returnObject=gson.fromJson(string, ReturnLatest.class);
			ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("/index");
	        modelAndView.addObject("returnObject", returnObject);
	        return modelAndView;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorModelAndView.setViewName("error");
	        return errorModelAndView;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorModelAndView.setViewName("error");   
	        return errorModelAndView;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			errorModelAndView.setViewName("error");
	        return errorModelAndView;
		}
		
      }
	  @RequestMapping("/clientview")
      @ResponseBody
      ModelAndView adminView(HttpServletRequest httprequest, HttpServletResponse httpresponse) {
		  HttpGet httpGet=null;
		  try {
			URIBuilder uriBuilder = new URIBuilder(API_URL_GETALL);
			  String username = httprequest.getParameter("user");
			  String type = httprequest.getParameter("type");
			  String productcode = httprequest.getParameter("product");
			  List<NameValuePair> list = new LinkedList<>();
			  BasicNameValuePair param1 = new BasicNameValuePair("user", username);
			  BasicNameValuePair param2 = new BasicNameValuePair("type", type);
			  BasicNameValuePair param3 = new BasicNameValuePair("product", productcode);
			  list.add(param1);
			  list.add(param2);
			  list.add(param3);
			  uriBuilder.addParameters(list);
			  httpGet = new HttpGet(uriBuilder.build());
			  HttpResponse response = client.execute(httpGet);
			  response.addHeader("content-type","application/json");
			  HttpEntity entity = response.getEntity();
			  String string = EntityUtils.toString(entity);
			  List<Block> returnObject=gson.fromJson(string, List.class);
			  ModelAndView modelAndView = new ModelAndView();
			  modelAndView.setViewName("/clientview");
			  modelAndView.addObject("returnObject", returnObject);
			  modelAndView.addObject("type", type);
			  modelAndView.addObject("productcode", productcode);
			  return modelAndView;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return errorModelAndView;
		} catch (URISyntaxException e) {
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