package com.bitcoin.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.model.Wallet;
import com.bitcoin.service.WalletService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value = "/*")
public class WalletAction extends ActionSupport implements RequestAware {

	private static final int PER_PAGE = 5;

	private Map<String, Object> m = ServletActionContext.getContext()
			.getSession();
	@Autowired
	private WalletService walletService;
	private String walletAddress;
	private int selected;
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	private Map<String, Object> request;

	public String getWalletAddress() {
		return walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}

	@Action(value = "wallet", results = { @Result(name = "success", location = "/WEB-INF/wallet.jsp") })
	public String wallet() throws Exception {

		// System.out.println((String)m.get("USER_MAIL"));
		return loadAll();

	}

	@Action(value = "add", results = { @Result(name = "success", location = "/WEB-INF/wallet.jsp") })
	public String add() throws Exception {

		String userMail = (String) m.get("USER_MAIL");
		if (userMail != null)
			walletService.add(userMail);

		return loadAll();

	}

	@Action(value = "delete", results = { @Result(name = "success", location = "/WEB-INF/wallet.jsp") })
	public String delete() throws Exception {

		System.out.println("delete-->" + walletAddress);
		Wallet wallet = walletService.load(walletAddress);
		System.out.println("wallet-->" + wallet.getUserMail());
		if (wallet != null)
			walletService.delete(wallet);

		return loadAll();

	}

	@Action(value = "update", results = { @Result(name = "success", location = "/WEB-INF/wallet.jsp") })
	public String update() throws Exception {

		Wallet wallet = walletService.load(walletAddress);

		if (wallet != null) {

			if (wallet.getWalletLocked() == 0)
				wallet.setWalletLocked(1);
			else
				wallet.setWalletLocked(0);

			walletService.update(wallet);

		}
		return loadAll();

	}

	@Action(value = "search", results = { @Result(name = "success", location = "/WEB-INF/wallet.jsp") })
	public String search() throws Exception {

		List<Wallet> listWallets = walletService
				.search(walletAddress, selected);
		request.put("list", listWallets);
		return SUCCESS;
	}

	public String loadAll() throws Exception {

		String sql = "select wallet_address,wallet_amount,wallet_locked from(select wallet_address,user_mail,wallet_amount,wallet_locked,rownum m from t_wallet ) where m between ? and ?";
		int walletCnt = walletService.getCount("select count(*) from t_wallet");
		if (page < 0)
			page = 0;

		request.put("curPage", page);
		request.put("totalPage", (walletCnt + PER_PAGE - 1) / PER_PAGE);
		List<Wallet> listWallets = walletService.getWalletListByLimit(sql, page
				* PER_PAGE, PER_PAGE - (page == 0 ? 0 : 1));
		request.put("list", listWallets);
		return SUCCESS;

	}

	public void setRequest(Map<String, Object> request) {

		this.request = request;

	}

}
