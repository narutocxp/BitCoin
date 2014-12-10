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

import com.bitcoin.model.User;
import com.bitcoin.model.Wallet;
import com.bitcoin.service.UserService;
import com.bitcoin.service.WalletService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value = "/*")
public class WalletAction extends ActionSupport implements RequestAware {

	private static final int PER_PAGE = 5;
	private static final int ALL = 2;
	private static int SELECTED_FLAG = ALL;
	private static String WALLET_SEARCH_ADDRESS_FLAG = "";
	private Map<String, Object> m = ServletActionContext.getContext()
			.getSession();
	@Autowired
	private WalletService walletService;
	@Autowired
	private UserService userService;
	
	private String walletAddress;
	private int selected;
	private int page;
	private Map<String, Object> request;

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
		SELECTED_FLAG = selected;

	}

	public String getWalletAddress() {
		return walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
		if (walletAddress != null && walletAddress.trim().length() < 16)
			WALLET_SEARCH_ADDRESS_FLAG = walletAddress;

	}

	@Action(value = "wallet", results = { @Result(name = "success", location = "/WEB-INF/wallet.jsp") })
	public String wallet() throws Exception {

		// System.out.println((String)m.get("USER_MAIL"));
		return state();
	}

	@Action(value = "add", results = { @Result(name = "success", location = "/WEB-INF/wallet.jsp") })
	public String add() throws Exception {

		User  user =(User)m.get("user");
		if (user != null)
			walletService.add(user.getUserMail());

		return loadAll();

	}

	@Action(value = "delete", results = { @Result(name = "success", location = "/WEB-INF/wallet.jsp") })
	public String delete() throws Exception {

		Wallet wallet = walletService.load(walletAddress);
		if (wallet != null)
			walletService.delete(wallet);

		return state();

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
		return state();

	}

	@Action(value = "search", results = { @Result(name = "success", location = "/WEB-INF/wallet.jsp") })
	public String search() throws Exception {

		String sql = "";
		int walletCnt = 0;
		User user=(User)m.get("user");
		String contition = "where user_mail='"+user.getUserMail()+"'";
		if (ALL == selected && (walletAddress == "" || walletAddress == null)) {
			contition += " ";
		} else if (ALL == selected
				&& (walletAddress != "" || walletAddress != null)) {
			contition += " and wallet_address like \'%" + walletAddress + "%\'";

		} else if (walletAddress == "" || walletAddress == null) {

			contition += " and wallet_locked=" + selected;

		} else {

			contition += " and wallet_address like \'%" + walletAddress
					+ "%\' and " + "wallet_locked=" + selected;

		}
		sql = "select wallet_address,wallet_amount,wallet_locked from(select wallet_address,user_mail,wallet_amount,wallet_locked,rownum m from t_wallet "
				+ contition + ") where m between ? and ?";
		walletCnt = walletService.getCount("select count(*) from t_wallet "
				+ contition + "");
		return pagination(sql, walletCnt);
	}

	public String loadAll() throws Exception {
        
		User user=(User)m.get("user");
		
		String sql = "select wallet_address,wallet_amount,wallet_locked from(select wallet_address,user_mail,wallet_amount,wallet_locked,rownum m from t_wallet where user_mail='"+user.getUserMail()+"') where m between ? and ?";
		int walletCnt = walletService.getCount("select count(*) from t_wallet  where user_mail='"+user.getUserMail()+"'");
		return pagination(sql, walletCnt);

	}

	public String pagination(String sql, int walletCnt) {

		if (page < 0)
			page = 0;

		request.put("curPage", page);
		request.put("totalPage", (walletCnt + PER_PAGE - 1) / PER_PAGE);
		List<Wallet> listWallets = walletService.getWalletListByLimit(sql, page
				* PER_PAGE, PER_PAGE - (page == 0 ? 0 : 1));
		request.put("list", listWallets);
		return SUCCESS;

	}

	public String state() throws Exception {

		if (SELECTED_FLAG == ALL) {

			return loadAll();
		} else {

			selected = SELECTED_FLAG;
			walletAddress = WALLET_SEARCH_ADDRESS_FLAG;
			return search();

		}
	}

	public void setRequest(Map<String, Object> request) {

		this.request = request;

	}

}
