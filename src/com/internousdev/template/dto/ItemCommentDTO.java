package com.internousdev.template.dto;

public class ItemCommentDTO {

	/**
     * ユーザーID
     */

    private int userId;

    /**
     *コメント内容
     */

    private String comment;

    /**
     * コメントした人の名前
     */
    private String userName;

    /**
     * コメントした日時
     */
    private String registrationDate;



    /**
     * registration_date 登録日取得メソッド
     * @return registration_date 登録日
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     *  registration_date 登録日格納メソッド
     * @param registration_date 登録日
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * user_name ユーザー名取得メソッド
     * @return user_name ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     *  user_name ユーザー名格納メソッド
     * @param user_name ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * user_id取得メソッド
     * @return user_id
     */
    public int getUserId() {
        return userId;
    }

    /**
     *   user_id 作り方IDを格納する
     *   @param user_id 作り方ID
     */
     public void setUserId(int userId) {
         this.userId = userId;
     }



     /**
      *   comment コメント内容を取得するメソッド
      *   @return comment コメント内容
      */
      public String getComment() {
          return comment;
      }

      /**
      *   comment コメント内容を格納する
      *   @param comment コメント内容
      */
      public void setComment(String comment) {
          this.comment = comment;
      }



}
