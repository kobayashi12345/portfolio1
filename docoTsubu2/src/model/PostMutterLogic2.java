package model;

import java.util.List;

public class PostMutterLogic2 {
  public void execute(Mutter2 mutter, List<Mutter2> mutterList) {
    mutterList.add(0, mutter); // 先頭に追加 解説①
  }
  public void liked(List<Mutter2> mutterList,int no) {
	  mutterList.get(no).setLike(mutterList.get(no).getLike()+1);
  }
  public void disliked(List<Mutter2> mutterList,int no) {
	  mutterList.get(no).setDislike(mutterList.get(no).getDislike()+1);
  }
}