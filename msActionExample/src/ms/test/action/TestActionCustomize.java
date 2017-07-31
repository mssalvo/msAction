package ms.test.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ms.framework.core.ActionModel;
import ms.framework.logic.ActionType;
import ms.framework.logic.IAction;
import ms.framework.logic.ICustomAction;
import ms.test.model.PersonMock;
import ms.test.model.PersonRest;

public class TestActionCustomize implements IAction{

	@Override
	public ActionType create(ActionModel arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws IOException, ServletException {
		PersonRest personRest = new PersonRest();
		personRest.setPersons(PersonMock.getPersons());
		 
		return JSON.BODY(personRest).CUSTOMIZE(new ICustomAction() {
			
			@Override
			public void execute(ActionType aType, ActionModel model, HttpServletRequest request, HttpServletResponse respons)
					throws IOException, ServletException {
				
			respons.getWriter().write(new Gson().toJson(aType.getContent()));
				
			}
		});
	 
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
