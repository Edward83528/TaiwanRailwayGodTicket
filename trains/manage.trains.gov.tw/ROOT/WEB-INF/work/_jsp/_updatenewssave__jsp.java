/*
 * JSP generated by Resin Professional 4.0.53 (built Fri, 16 Jun 2017 02:25:02 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import tw.com.common.*;
import java.util.*;

public class _updatenewssave__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  private boolean _caucho_isNotModified;
  private com.caucho.jsp.PageManager _jsp_pageManager;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);

    TagState _jsp_state = null;

    try {
      _jspService(request, response, pageContext, _jsp_application, session, _jsp_state);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_pageManager.freePageContext(pageContext);
    }
  }
  
  private void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response,
              com.caucho.jsp.PageContextImpl pageContext,
              javax.servlet.ServletContext application,
              javax.servlet.http.HttpSession session,
              TagState _jsp_state)
    throws Throwable
  {
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    javax.servlet.jsp.tagext.JspTag _jsp_parent_tag = null;
    com.caucho.jsp.PageContextImpl _jsp_parentContext = pageContext;
    response.setContentType("text/html; charset=UTF-8");

    out.write(_jsp_string0, 0, _jsp_string0.length);
    
		//\u89e3\u6c7a\u7de8\u78bc\u554f\u984c
		request.setCharacterEncoding("UTF-8");
		//\u63a5\u6536\u53c3\u6578
		String Id = (String) request.getParameter("id");
		String Subject = request.getParameter("Subject");
		String Content = request.getParameter("Content");
		String Link = request.getParameter("Link");
		String Picture = request.getParameter("Pitcure");
		TrainData trainData = new TrainData();
		boolean check = trainData.UpdateNews(Id, Subject, Content, Link, Picture);
		if (check == true) {
			System.out.println("\u66f4\u65b0\u6210\u529f");
	
    out.write(_jsp_string1, 0, _jsp_string1.length);
    
		} else {
			System.out.println("\u66f4\u65b0\u5931\u6557");
	
    out.write(_jsp_string2, 0, _jsp_string2.length);
    
		}
	
    out.write(_jsp_string3, 0, _jsp_string3.length);
  }

  private com.caucho.make.DependencyContainer _caucho_depends
    = new com.caucho.make.DependencyContainer();

  public java.util.ArrayList<com.caucho.vfs.Dependency> _caucho_getDependList()
  {
    return _caucho_depends.getDependencies();
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    _caucho_depends.add(depend);
  }

  protected void _caucho_setNeverModified(boolean isNotModified)
  {
    _caucho_isNotModified = true;
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;

    if (_caucho_isNotModified)
      return false;

    if (com.caucho.server.util.CauchoSystem.getVersionId() != 4732978526484063000L)
      return true;

    return _caucho_depends.isModified();
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
    TagState tagState;
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("updateNewsSave.jsp"), -203839928993577392L, false);
    _caucho_depends.add(depend);
    loader.addDependency(depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("include/resources.jsp"), 6804450726358218760L, false);
    _caucho_depends.add(depend);
    loader.addDependency(depend);
  }

  final static class TagState {

    void release()
    {
    }
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void caucho_init(ServletConfig config)
  {
    try {
      com.caucho.server.webapp.WebApp webApp
        = (com.caucho.server.webapp.WebApp) config.getServletContext();
      init(config);
      if (com.caucho.jsp.JspManager.getCheckInterval() >= 0)
        _caucho_depends.setCheckInterval(com.caucho.jsp.JspManager.getCheckInterval());
      _jsp_pageManager = webApp.getJspApplicationContext().getPageManager();
      com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
      com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.InitPageContextImpl(webApp, this);
    } catch (Exception e) {
      throw com.caucho.config.ConfigException.create(e);
    }
  }

  private final static char []_jsp_string0;
  private final static char []_jsp_string2;
  private final static char []_jsp_string3;
  private final static char []_jsp_string1;
  static {
    _jsp_string0 = "\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=BIG5\">\r\n<!-- \u8cc7\u6e90\u6a94 -->\r\n\r\n<title>\u53f0\u9435\u795e\u7968\u624b\u5f8c\u53f0</title>\r\n<link rel=\"shortcut icon\" href=\"image/logo.png\">\r\n<link rel=\"stylesheet\" href=\"css/screen.css\">\r\n<script\r\n	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n<script src=\"js/public.js\"></script>\r\n<link\r\n	href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css\"\r\n	rel=\"stylesheet\">\r\n<script type=\"text/javascript\"\r\n	src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js\"></script>\r\n<script src=\"js/datepicker.js\"></script>\r\n<!-- \u522a\u9664\u6307\u4ee4\u7528\u5230 -->\r\n<script type=\"text/javascript\" src=\"/js/jquery.form.js\"></script>\r\n\r\n</head>\r\n<body>\r\n	".toCharArray();
    _jsp_string2 = "\r\n	<script>\r\n		alert(\"\u66f4\u65b0\u5931\u6557!\");\r\n		window.location.href = \"new.jsp\";\r\n	</script>\r\n	".toCharArray();
    _jsp_string3 = "\r\n\r\n</body>\r\n</html>".toCharArray();
    _jsp_string1 = "\r\n	<script>\r\n		alert(\"\u66f4\u65b0\u6210\u529f!\");\r\n		window.location.href = \"new.jsp\";\r\n	</script>\r\n	".toCharArray();
  }
}