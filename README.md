# msAction
Lightweight Java java management tool manages responses in json, xml, and html format in a fast and fluid way


## config web.xml
### implements:
    <servlet>
        <servlet-name>ActionManager</servlet-name>
        <servlet-class>ms.framework.core.ActionManager</servlet-class>
        <init-param>
            <param-name>base</param-name>
        <!-- Indicate the directory directory path where all the classes that implement the IAction interface will be placed -->
            <param-value>ms.my.package.action</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>ActionManager</servlet-name>
        <url-pattern>*.am</url-pattern>
    </servlet-mapping>
 
 ## Example generate json, xml and html responses:
 #### Class declaration
 
 public class Agenda implements IAction{
 
 @Override
 
    public ActionType create(ActionModel model, HttpServletRequest request, HttpServletResponse response) throws IOException,               ServletException { 
      
      List<Appointments> appointments= getAppointments();
        /*
        *Return json
        */
       
       return JSON.BODY(appointments);
        
        OR
        
        /*
        *Return xml
        */
         return XML.BODY(appointments);
         
          OR
        
        /*
        *Return html
        */
         return HTML.BODY("HEllo Word!");
         
           OR
        
        /*
        *Return html
        * It redirects to the jsp page shown
        */
        
          model.addAttribute("myKey","My Greeting !!")
         
         return URL.DIRECT("/page/jsp/greeting.jsp");
    }

    @Override
    public String validate(ActionModel model, HttpServletRequest request, HttpServletResponse response) throws IOException,                 ServletException {
      return SUCCESS;
    } 
}

## Here's how to recall the action
### For our Agenda class
#### http://mysite/Agenda.am
### For our MyClass class
#### http://mysite/MyClass.am

##### Lightweight and easy to implement without too many configurations.
