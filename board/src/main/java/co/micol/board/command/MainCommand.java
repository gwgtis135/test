package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MainCommand implements Command {

	@Override
	public String run(HttpServletRequest ruquest, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		return "main/main";	//view 
	}

}
