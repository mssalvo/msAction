package ms.test.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.framework.core.ActionModel;
import ms.framework.logic.ActionType;
import ms.framework.logic.IAction;

public class TestActionHtml implements IAction {

	@Override
	public ActionType create(ActionModel arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws IOException, ServletException {
	 
		
		
		return HTML.BODY("<div><b>Hello!!!</b></div>");
	}
	
	@Override
	public String validate(ActionModel arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws IOException, ServletException {
		// SUCCESS Runs the create() method
		// FAILURE Blocking execution of the method you create() in the method will not run
		// NULL    Runs the create() method
		// return SUCCESS or FAILURE or null
		return null;
	}
	
}
