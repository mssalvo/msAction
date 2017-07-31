package ms.test.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import ms.framework.core.ActionModel;
import ms.framework.logic.ActionType;
import ms.framework.logic.IAction;
import ms.framework.logic.IConfigureMarshaller;
import ms.test.model.PersonMock;
import ms.test.model.PersonRest;

public class TestActionConfMarshaller implements IAction{

	@Override
	public ActionType create(ActionModel arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws IOException, ServletException {
		
		PersonRest personRest = new PersonRest();
		personRest.setPersons(PersonMock.getPersons());

		return XML.BODY(personRest).CONF_MARSHALLER(new IConfigureMarshaller() {
		 
            @Override 
            public void set(Marshaller marshaller) throws PropertyException {
          
               marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                
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
