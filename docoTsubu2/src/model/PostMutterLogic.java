package model;

import dao.MutterDAO;

public class PostMutterLogic {
  public void execute(Mutter2 mutter) {
    MutterDAO dao = new MutterDAO();
    dao.create(mutter);
  }
}