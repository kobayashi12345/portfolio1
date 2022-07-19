package model;

import java.io.Serializable;

public class Mutter2 implements Serializable {
  private String userName; // ユーザー名
  private String text; // つぶやき内容
  	private int like;	//よいね数
	private int dislike;//よくないね数
	private int id;


  public Mutter2() {
  }

  public Mutter2(String userName, String text) {
    this.userName = userName;
    this.text = text;
  	this.like = 0;
  	this.dislike = 0;
  }

  public Mutter2(int id, String userName, String text, int like, int dislike) {
	this.id = id;
    this.userName = userName;
    this.text = text;
    this.like = like;
    this.dislike =dislike;
  }

  public String getUserName() {
    return userName;
  }

  public String getText() {
    return text;
  }

public int getLike() {
	return like;
}

public void setLike(int like) {
	this.like = like;
}

public int getDislike() {
	return dislike;
}

public void setDislike(int dislike) {
	this.dislike = dislike;
}
public int getId(){
	  return id;
}
}