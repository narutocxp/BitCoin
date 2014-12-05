package com.bitcoin.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.utils.HttpTookit;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value = "/*")
public class BitCoinPriceAction extends ActionSupport implements RequestAware {

	private Map<String, Object> request;

	@Action(value = "latestprice", results = { @Result(name = "success", location = "/WEB-INF/bitcoinprice.jsp") })
	public String latestPrice() throws Exception {

		String html = HttpTookit.doPost("https://vip.btcchina.com/", null,
				"utf-8", true);
		List<String> infoList = new ArrayList<String>();
		Document doc = Jsoup.parse(html);
		Elements element = doc.select("tbody>tr>td");
		Iterator<Element> itr = element.iterator();
		int flag = 1;
		int count = 0;
		String strInfo;
		while (itr.hasNext()) {
			strInfo = itr.next().html();
			if (strInfo.equals("BTC China") && flag == 1) {
				infoList.add(strInfo);
				count++;
				flag = 0;

			} else if (flag == 0) {

				infoList.add(strInfo);
				count++;
				if (count >= 21)
					break;
			}

		}
       
		 request.put("infoList", infoList);
		
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> request) {

		this.request = request;
	}

}
