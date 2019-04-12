package net.matthew.app.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

import net.matthew.Static_Value;
import com.v5ent.entity.Block;
import com.v5ent.entity.ReturnLatest;

@Controller
public class ServerController {
	private static DefaultHttpClient client = new DefaultHttpClient();
	private static Block errorblock = Block.createErrorBlock();
	final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/getAll")
	@ResponseBody
	String getAllBlock(HttpServletRequest request) {
		String user = request.getParameter("user");
		String type = request.getParameter("type");
		String url=Static_Value.ABS_A_MASTER_CHAIN_DOMAIN;
		int port = Static_Value.ABS_A_MASTER_CHAIN_PORT;
		if(type!=null&&Static_Value.TYPE_CAPITAL.equals(type)) {
			url=Static_Value.ABS_A_CAPITAL_CHAIN_DOMAIN;
			port=Static_Value.ABS_A_CAPITAL_CHAIN_PORT;
		}
		if(type!=null&&Static_Value.TYPE_REPUTATION.equals(type)) {
			url=Static_Value.ABS_A_REPUTATION_CHAIN_DOMAIN;
			port=Static_Value.ABS_A_REPUTATIONL_CHAIN_PORT;
		}
		if(type!=null&&Static_Value.TYPE_VALUE.equals(type)) {
			url=Static_Value.ABS_A_VALUE_CHAIN_DOMAIN;
			port=Static_Value.ABS_A_VALUE_CHAIN_PORT;
		}
		return "get";

	}

	@RequestMapping("/addBlock")
	@ResponseBody
	String addBlock(HttpServletRequest request) {
		String productCode = request.getParameter("productCode");
		String url = Static_Value.ABS_A_MASTER_CHAIN_DOMAIN;
		int port = Static_Value.ABS_A_MASTER_CHAIN_PORT;
		if (productCode == null || "".equals(productCode.trim())) {
			productCode = "a";
		}
		String type = request.getParameter("type");
		if (type == null || "".equals(type.trim())) {
			url = Static_Value.ABS_A_MASTER_CHAIN_DOMAIN;
			port = Static_Value.ABS_A_MASTER_CHAIN_PORT;
		}
		if (Static_Value.TYPE_CAPITAL.equals(type)) {
			url = Static_Value.ABS_A_CAPITAL_CHAIN_DOMAIN;
			port = Static_Value.ABS_A_CAPITAL_CHAIN_PORT;
		}
		if (Static_Value.TYPE_REPUTATION.equals(type)) {
			url = Static_Value.ABS_A_REPUTATION_CHAIN_DOMAIN;
			port = Static_Value.ABS_A_REPUTATIONL_CHAIN_PORT;
		}
		if (Static_Value.ABS_A_VALUE_CHAIN_DOMAIN.equals(type)) {
			url = Static_Value.ABS_A_VALUE_CHAIN_DOMAIN;
			port = Static_Value.ABS_A_VALUE_CHAIN_PORT;
		}
		String vac = request.getParameter("vac");
		String name = request.getParameter("name");
		Block returnBlock = getPostValue(Static_Value.HTTP, port, Static_Value.ABS_DEFAULT_POST_METHOD, vac, name);
		return gson.toJson(returnBlock);
	}

	@RequestMapping("/getlatest")
	@ResponseBody
	String getLatest(HttpServletRequest request, HttpServletResponse response) {
		boolean isAdmin = false;
		String productCode = request.getParameter("productCode");
		String user = request.getParameter("user");
		if (user!=null&&"admin".equals(user)) {
			isAdmin = true;
		}
		response.addHeader("content-type", "application/json");
		ReturnLatest returnObject = new ReturnLatest();
		if (productCode == null || "".equals(productCode.trim())) {
			productCode = "a";
		}
		if ("a".equals(productCode)) {
			Block productCaptialBlock = getGetValue(Static_Value.HTTP + Static_Value.ABS_A_CAPITAL_CHAIN_DOMAIN,
					Static_Value.ABS_A_CAPITAL_CHAIN_PORT, Static_Value.ABS_GET_LAST_METHOD, isAdmin);
			Block productReputationBlock = getGetValue(Static_Value.HTTP + Static_Value.ABS_A_REPUTATION_CHAIN_DOMAIN,
					Static_Value.ABS_A_REPUTATIONL_CHAIN_PORT, Static_Value.ABS_GET_LAST_METHOD, isAdmin);
			Block valueBlock = getGetValue(Static_Value.HTTP + Static_Value.ABS_A_VALUE_CHAIN_DOMAIN,
					Static_Value.ABS_A_VALUE_CHAIN_PORT, Static_Value.ABS_GET_LAST_METHOD, isAdmin);
			returnObject.setCode(productCode);
			returnObject.setCapital(productCaptialBlock);
			returnObject.setReputation(productReputationBlock);
			returnObject.setValue(valueBlock);
		}
		return gson.toJson(returnObject);
	}

	Block getGetValue(String url, int port, String method, boolean isAdmin) {
		HttpGet httpGet = new HttpGet(url + ":" + port + "/" + method);
		try {
			HttpResponse response = client.execute(httpGet);
			response.addHeader("content-type", "application/json");
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			Block returnBlock = gson.fromJson(string, Block.class);
			boolean illegalContent = false;
			int index = -1;
			String hash = "";
			if (!isAdmin) {
				if (returnBlock.getVac().contains("illegalContent")) {
					illegalContent = true;
					index = returnBlock.getIndex();
					hash = returnBlock.getHash();
					returnBlock = getGetValue(url, port,
							Static_Value.ABS_GET_BY_INDEX_METHOD + "/" + (returnBlock.getIndex() - 1), isAdmin);

				}
				if (illegalContent) {
					returnBlock.setComments(
							"The content you visit is has illegalContent in the latestblock, so we show older one to you"
									+ "please contact Admin to fix it, the index is " + index
									+ ", and the hash code is " + hash);
				}
			}
			return returnBlock;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return errorblock;
		} catch (IOException e) {
			e.printStackTrace();
			return errorblock;
		} finally {
			httpGet.releaseConnection();
		}

	}
	List<Block> getAllValue(String url, int port, String method, boolean isAdmin) {
		HttpGet httpGet = new HttpGet(url + ":" + port + "/" + method);
		try {
			HttpResponse response = client.execute(httpGet);
			response.addHeader("content-type", "application/json");
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			List<Block> returnChain = gson.fromJson(string, List.class);
			boolean illegalContent = false;
			int index = -1;
			String hash = "";

			return returnChain;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return new LinkedList<Block>();
		} catch (IOException e) {
			e.printStackTrace();
			return new LinkedList<Block>();
		} finally {
			httpGet.releaseConnection();
		}
	}
	Block getPostValue(String url, int port, String method, String vac, String name) {
		HttpPost httpPost = new HttpPost(url + ":" + port + "/" + method);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("vac", vac);
		jsonParam.put("name", name);
		StringEntity postEntity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		postEntity.setContentEncoding("UTF-8");
		postEntity.setContentType("application/json");
		httpPost.setEntity(postEntity);
		// httpPost.setEntity(postEntity);
		try {

			HttpResponse response = client.execute(httpPost);
			response.addHeader("content-type", "application/json");
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			Block returnBlock = gson.fromJson(string, Block.class);
			return returnBlock;
		} catch (ClientProtocolException e) {

			e.printStackTrace();
			return errorblock;
		} catch (IOException e) {

			e.printStackTrace();
			return errorblock;
		} finally {
			httpPost.releaseConnection();
		}

	}

}