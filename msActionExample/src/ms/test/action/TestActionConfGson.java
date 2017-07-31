package ms.test.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import ms.framework.core.ActionModel;
import ms.framework.logic.ActionType;
import ms.framework.logic.IAction;
import ms.framework.logic.IConfigureGson;
import ms.test.model.PersonMock;
import ms.test.model.PersonRest;

public class TestActionConfGson implements IAction {

	@Override
	public ActionType create(ActionModel arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws IOException, ServletException {

		PersonRest personRest = new PersonRest();
		personRest.setPersons(PersonMock.getPersons());

		return JSON.BODY(personRest).CONF_GSON(new IConfigureGson() {

			@Override
			public void set(GsonBuilder builder) {

				builder.registerTypeAdapter(Date.class, new JsonDeserializer() {
					@Override
					public Date deserialize(JsonElement je, java.lang.reflect.Type type, JsonDeserializationContext jdc)
							throws JsonParseException {
						return new Date(je.getAsJsonPrimitive().getAsLong());
					}
				});

				builder.setDateFormat("yyyy-MM-dd");
			}

		});
	}

	@Override
	public String validate(ActionModel arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws IOException, ServletException {
		// SUCCESS Runs the create() method
		// FAILURE Blocking execution of the method you create() in the method
		// will not run
		// NULL Runs the create() method
		// return SUCCESS or FAILURE or null
		return null;
	}

}
