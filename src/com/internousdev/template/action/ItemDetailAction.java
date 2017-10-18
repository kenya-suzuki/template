package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.internousdev.template.dao.ItemDetailDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemCommentDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailAction extends ActionSupport {



    /**
     * シリアルID
     */
    private static final long serialVersionUID = 265702236011588767L;

    /**
     * 商品リスト
     */
    private List<ItemDTO> itemList;

    /**
     * 商品ID
     */
    private int itemId;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * 種類ID
     */
    private int categoryId;

    /**
     * 単価
     */
    private BigDecimal price;

    /**
     * 商品詳細
     */
    private String itemDetail;

    /**
     * 在庫数
     */
    private int stocks;

    /**
     * 商品一覧表示用リスト
     */
    private ArrayList<ItemDTO> displayList = new ArrayList<ItemDTO>();

    /**
     * 商品一覧表示用リスト
     */
    private ArrayList<ItemCommentDTO> commentttt = new ArrayList<ItemCommentDTO>();

    private String commenttest;

    /**
     * 在庫数をリストに格納
     */
    private ArrayList<Integer> stockList;

    /**
     * アイテムIDリスト
     */
    private List<CartDTO> itemIdList;

    /**
     * 注文個数
     */
    private int itemCount;

    /**
     * セッション
     */
    private Map<String, Object> session;

    /**
     * 顧客ID
     */
    private int userId;

    /**
     * メッセージ
     */
    private boolean msg;

    /**
     * 商品一覧表示用リストの生成
     *
     */
    public String execute() throws SQLException {
        String result = ERROR;
        ItemDetailDAO dao = new ItemDetailDAO();
        displayList = dao.selectbyItem(itemId);
        commentttt = dao.selectCommentList(itemId);
        if (displayList.size() != 0) {
            result = SUCCESS;
        }
        return result;
    }

    /**
     * 実行メソッド
     * 商品詳細ページに遷移するメソッド
     * @return result SUCCESS、ERROR
     * @throws SQLException エラー処理
     */
    public String execute2() throws SQLException {
        String result = ERROR;
        ItemDetailDAO dao = new ItemDetailDAO();
        stockList = new ArrayList<Integer>();
        itemList = dao.selectbyItem(itemId);
        if (session.containsKey("userId")) {
            setUserId((int) session.get("userId"));
        }
        for (int i = 1; i <= itemList.get(0).getStock(); i++) {
            if (i >= 10) {
                break;
            }
            stockList.add(i);
        }

        for (CartDTO dto : itemIdList) {
            if (dto.getItemId() == itemId) {
                setMsg(true);
            }
        }
        return result;

    }

    /**
     * 商品IDを取得するメソッド
     * @return itemId　商品ID
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * 商品IDを格納するメソッド
     * @param itemId セットする itemId
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 商品名を取得するメソッド
     * @return itemsName　商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名を格納するメソッド
     * @param itemName セットする itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 種類IDを取得するメソッド
     * @return sortId 種類ID
     */
    public int getcategoryId() {
        return categoryId;
    }

    /**
     * 種類IDを格納するメソッド
     * @param categoryId セットする sortId
     */
    public void setSortId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 単価を取得するメソッド
     * @return price　単価
     */
    public  BigDecimal getPrice() {
        return price;
    }

    /**
     * 単価を格納するメソッド
     * @param price セットする price
     */
    public void setPrice( BigDecimal price) {
        this.price = price;
    }

    /**
     * 商品詳細を取得するメソッド
     * @return itemsDetail　商品詳細
     */
    public String getItemDetail() {
        return itemDetail;
    }

    /**
     * 商品詳細を格納するメソッド
     * @param itemDetail セットする itemDetail
     */
    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    /**
     * 商品一覧表示用リストを取得するメソッド
     * @return displayList　商品一覧表示用リスト
     */
    public ArrayList<ItemDTO> getDisplayList() {
        return displayList;
    }

    /**
     * 商品一覧表示用リストを格納するメソッド
     * @param displayList セットする displayList
     */
    public void setDisplayList(ArrayList<ItemDTO> displayList) {
        this.displayList = displayList;
    }

    /**
     * 商品一覧表示用リストを取得するメソッド
     * @return displayList　商品一覧表示用リスト
     */
    public ArrayList<ItemCommentDTO> getCommentttt() {
        return this.commentttt;
    }

    /**
     * 商品一覧表示用リストを格納するメソッド
     * @param displayList セットする displayList
     */
    public void setCommentttt(ArrayList<ItemCommentDTO> commentttt) {
        this.commentttt = commentttt;
    }

    /**
     * @return stockList
     */
    public ArrayList<Integer> getStockList() {
        return stockList;
    }

    /**
     * @param stockList セットする stockList
     */
    public void setStockList(ArrayList<Integer> stockList) {
        this.stockList = stockList;
    }

    /**
     * @return itemCount
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * @param itemCount セットする itemCount
     */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    /**
     * @return msg
     */
    public boolean isMsg() {
        return msg;
    }

    /**
     * @param msg セットする msg
     */
    public void setMsg(boolean msg) {
        this.msg = msg;
    }

    /**
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return stocks 在庫数
     */
    public int getStocks() {
        return stocks;
    }

    /**
     * @param stocks 在庫数をセットする
     */
    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public void setCommenttest(String commenttest) {
        this.commenttest = commenttest;
    }

    public String getCommenttest() {
    	return this.commenttest;
    }

}
