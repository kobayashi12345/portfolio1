package model;

public class LoginLogic {
  public boolean execute(User user) {
	  String acount[] = {"湊雄輔","渡部めぐみ",""};
	  String password[] = {"5678","1235","1234"};

	if (user.getName().equals("湊雄輔")){
	  	if(user.getPass().equals("1234")) {
	   		return true;
	   	}
	}else if (user.getPass().equals("1234")) {
      return true;
    }
    return false;
  }
}