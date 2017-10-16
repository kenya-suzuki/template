package com.internousdev.template.dto;

import java.math.BigDecimal;

public class ItemDTO {

	/**
     * 商品ID
     */
    private int itemId;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * 作者
     */
    private String author;

    /**
     * カテゴリー名
     */
    private String itemCategory;

    /**
     * 価格
     */
    private  BigDecimal price;

    /**
     * 数量
     */
    private int quantities;

    /**
     * 商品説明文
     */
    private String overview;

    /**
     * イメージパス
     */
    private String itemImage;


    /**
     * 在庫数
     */
    private int stock;

    /**
     * 登録日
     */
    private String registrationDate;

    /**
     * 更新日
     */
    private String updatedDate;

    /**
     * 売り上げ
     */
    private  int sales;

    /**
     * アイテムリストから値を取得するためのインデックス番号
     */
    private int index;


    /**
     * 商品IDを取得するメソッド
     * @return itemId 商品ID
     */
    public int getItemId(){
        return itemId;
    }

    /**
     * 商品IDを格納するメソッド
     * @param itemId セットする 商品ID
     */
    public void setItemId(int itemId){
        this.itemId=itemId;
    }

    /**
     * 商品名を取得するメソッド
     * @return itemName 商品名
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * 商品名を格納するメソッド
     * @param itemName セットする 商品名
     */
    public void setItemName(String itemName){
        this.itemName=itemName;
    }

    /**
     * 作者を取得するメソッド
     */
    public String getAuthor(){
    	return author;
    }

    /**
     * 作者を格納するメソッド
     */
    public void setAuthor(String author){
    	this.author = author;
    }

    /**
     * カテゴリーを取得するメソッド
     * @return itemCategory 商品カテゴリー
     */
    public String getItemCategory(){
        return itemCategory;
    }

    /**
     * カテゴリーを格納するメソッド
     * @param itemCategory セットする 商品カテゴリー
     */
    public void setItemCategory(String itemCategory){
        this.itemCategory=itemCategory;
    }

    /**
     * 価格を取得するメソッド
     * @return price 価格
     */
    public  BigDecimal getPrice(){
        return price;
    }

    /**
     * 価格を格納するメソッド
     * @param price セットする 価格
     */
    public void setPrice( BigDecimal price){
        this.price=price;
    }

    /**
     * 数量を取得するメソッド
     * @return quentities 数量
     */
    public int getQuantities(){
        return quantities;
    }

    /**
     * 数量を格納するメソッド
     * @param quantities セットする 数量
     */
    public void setQuantities(int quantities){
        this.quantities= quantities;
    }

    /**
     * 詳細文を取得するメソッド
     * @return overview 詳細文
     */
    public String getOverview(){
        return overview;
    }

    /**
     * 詳細文を格納するメソッド
     * @param overview セットする 詳細文
     */
    public void setOverview(String overview){
        this.overview=overview;
    }

    /**
     * イメージパスを取得するメソッド
     * @return imagePath イメージパス
     */
    public String getItemImage() {
        return itemImage;
    }

    /**
     * イメージパスを格納するメソッド
     * @param imagePath セットする イメージパス
     */
    public void setImagePath(String itemImage) {
        this.itemImage = itemImage;
    }

    /**
     * 在庫数を取得するメソッド
     * @return stock 在庫数
     */
    public int getStock(){
        return stock;
    }

    /**
     * 在庫数を格納するメソッド
     * @param stock セットする 在庫数
     */
    public void setStock(int stock){
        this.stock=stock;
    }

    /**
     * 登録日を取得するメソッド
     * @return resgistrationDate 登録日
     */
    public String getRegistrationDate(){
        return registrationDate;
    }

    /**
     * 登録日を格納するメソッド
     * @param registrationDate セットする 登録日
     */
    public void setRegistrationDate(String registrationDate ){
        this.registrationDate=registrationDate;
    }

    /**
     * 更新日を取得するメソッド
     * @return updatedDate 更新日
     */
    public String getUpdatedDate(){
        return updatedDate;
    }

    /**
     * 更新日を格納するメソッド
     * @param updatedDate セットする 更新日
     */
    public void setUpdatedDate(String updatedDate){
        this.updatedDate=updatedDate;
    }

    /**
     * アイテムリストから値を取得するためのインデックス番号を取得します。
     * @return アイテムリストから値を取得するためのインデックス番号
     */
    public int getIndex() {
        return index;
    }

    /**
     * アイテムリストから値を取得するためのインデックス番号を設定します。
     * @param index アイテムリストから値を取得するためのインデックス番号
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * 売り上げを取得するメソッド
     * @return sales 売り上げ
     */
    public int getSales() {
        return sales;
    }

    /**
     * 売り上げを格納するメソッド
     * @param sales セットする 売上げ
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

}
