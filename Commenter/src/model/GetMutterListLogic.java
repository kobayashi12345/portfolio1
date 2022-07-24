package model;

import java.util.List;

import dao.MutterDAO;



public class GetMutterListLogic {

	public  List<Mutter2>execute() {
		MutterDAO dao = new MutterDAO();
		List<Mutter2> mutterList = dao.findAll();
		return mutterList;
	}

}
