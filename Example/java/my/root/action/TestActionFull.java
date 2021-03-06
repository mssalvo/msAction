/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.root.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ms.framework.core.ActionModel;
import ms.framework.logic.ActionType;
import ms.framework.logic.IAction;
import ms.framework.logic.ICustomAction;

/**
 *
 * @author user
 */
public class TestActionFull implements IAction{

    @Override
    public ActionType create(ActionModel am, HttpServletRequest hsr, HttpServletResponse hsr1) throws IOException, ServletException {
        
        PersonaRest personaRest= new PersonaRest();
        personaRest.setPersonas(PersonaDAO());
        String type=ActionType.JSON;
       
        if(hsr.getParameter("type")!=null)
        {
            type=hsr.getParameter("type");
        }
        
        switch(type){
            case ActionType.JSON:
                return JSON.BODY(personaRest);
            case ActionType.XML:
                 return XML.BODY(personaRest);
            case ActionType.HTML:
                return HTML.BODY("Hello!!!!!")  .CUSTOMIZE(new ICustomAction() {
            @Override
            public void execute(ActionType at, ActionModel am, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
              am.addAttribute("saluto", "Questa e una azione customizzata");
              req.getRequestDispatcher("/page/jsp/saluto.jsp").forward(req, resp);
            }
        }); 
           
        }
        
       
        
        return JSON.BODY(personaRest);
    }

    @Override
    public String validate(ActionModel am, HttpServletRequest hsr, HttpServletResponse hsr1) throws IOException, ServletException {
           
        //Fai le tue validazioni e ritorna SUCCESS or FAILURE
        
              return SUCCESS; 
    }
    
    
    	public List<Persona> PersonaDAO() {
		
		List<Persona> personaList = new ArrayList<Persona>();
		Persona persona = new Persona(1, "Marco", "Rossi", 40, "02/456327819", "mrossi@email.it");
		personaList.add(persona);
		
		persona = new Persona(2, "Gianni", "Bianchi", 45, "02/918273645", "lbianchi@email.it");
		personaList.add(persona);
		
		persona = new Persona(3, "Franco", "Neri", 32, "02/987123546", "fneri@email.it");
		personaList.add(persona); 
		
		persona = new Persona(4, "Paolo", "Verdi", 35, "02/129834765", "pverdi@email.it");
		personaList.add(persona); 	
		
		return personaList;
		
	}
}
