package ms.test.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.framework.core.ActionModel;
import ms.framework.logic.ActionType;
import ms.framework.logic.IAction;
import ms.test.model.Person;
import ms.test.model.PersonMock;

public class TestActionDirect implements IAction {

	@Override
	public ActionType create(ActionModel model, HttpServletRequest arg1, HttpServletResponse arg2)
			throws IOException, ServletException {
		
		List<Person> listPerson = PersonMock.getPersons();

		model.addAttribute("persons", listPerson);

		return URL.DIRECT("/mytest.jsp");
	}

	@Override
	public String validate(ActionModel model, HttpServletRequest arg1, HttpServletResponse arg2)
			throws IOException, ServletException {
		// SUCCESS Runs the create() method
		// FAILURE Blocking execution of the method you create() in the method
		// will not run
		// NULL Runs the create() method
		// return SUCCESS or FAILURE or null
		return null;
	}

}
