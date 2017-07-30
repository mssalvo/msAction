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



## Detail
public interface IAction

Field Summary

Field Detail
  
#### SUCCESS
static final java.lang.String SUCCESS
#### FAILURE
static final java.lang.String FAILURE

See Also: Constant Field Values

#### URL
static final ActionType URL

  
#### SKIP
static final ActionType SKIP

  
#### JSON
static final ActionType JSON

  
#### XML
static final ActionType XML

  
#### HTML
static final ActionType HTML


public interface IAction   
Method Detail
  
#### create
ActionType create(ActionModel model,
                  javax.servlet.http.HttpServletRequest request,
                  javax.servlet.http.HttpServletResponse response)
           throws java.io.IOException,
                  javax.servlet.ServletException
Throws:java.io.IOExceptionjavax.servlet.ServletException
  
#### validate
java.lang.String validate(ActionModel model,
                          javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
                   throws java.io.IOException,
                          javax.servlet.ServletException
Throws:java.io.IOExceptionjavax.servlet.ServletException






Class ActionType

#### CHAR_ENCODING
public ActionType CHAR_ENCODING(java.lang.String characterEncoding)

  
#### CONTENT_TYPE
public ActionType CONTENT_TYPE(java.lang.String contentType)

  
#### BODY
public ActionType BODY(java.lang.Object content)

  
#### DIRECT
public ActionType DIRECT(java.lang.String pathPage)

  
#### CUSTOMIZE
public ActionType CUSTOMIZE(ICustomAction action)

  
#### CONF_GSON
public ActionType CONF_GSON(IConfigureGson configureGson)

  
#### CONF_MARSHALLER
public ActionType CONF_MARSHALLER(IConfigureMarshaller confMarshaller)

## :)
#### You have everything you need to be able to work without stress, you can go big with the custom methods available
