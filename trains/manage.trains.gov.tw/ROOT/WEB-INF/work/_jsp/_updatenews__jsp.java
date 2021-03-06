/*
 * JSP generated by Resin Professional 4.0.53 (built Fri, 16 Jun 2017 02:25:02 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import tw.com.common.*;
import java.util.*;

public class _updatenews__jsp extends com.caucho.jsp.JavaPage
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
    
			String id = request.getParameter("id");
			TrainData trainDate = new TrainData();
			ArrayList<NewsItem> lists = trainDate.SelectNew(id);
			if (lists != null) {
				NewsItem list = lists.get(0);
		
    out.write(_jsp_string1, 0, _jsp_string1.length);
    out.print((id));
    out.write(_jsp_string2, 0, _jsp_string2.length);
    out.print((list.getSubject()));
    out.write(_jsp_string3, 0, _jsp_string3.length);
    out.print((list.getContent()));
    out.write(_jsp_string4, 0, _jsp_string4.length);
    if (list.getLink() != null) {
    out.write(_jsp_string5, 0, _jsp_string5.length);
    out.print((list.getLink()));
    out.write(_jsp_string6, 0, _jsp_string6.length);
    }
    out.write(_jsp_string7, 0, _jsp_string7.length);
    out.print((list.getPicture()));
    out.write(_jsp_string8, 0, _jsp_string8.length);
    
					}
				
    out.write(_jsp_string9, 0, _jsp_string9.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("updateNews.jsp"), 455124934675566506L, false);
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

  private final static char []_jsp_string4;
  private final static char []_jsp_string6;
  private final static char []_jsp_string8;
  private final static char []_jsp_string5;
  private final static char []_jsp_string3;
  private final static char []_jsp_string1;
  private final static char []_jsp_string7;
  private final static char []_jsp_string2;
  private final static char []_jsp_string9;
  private final static char []_jsp_string0;
  static {
    _jsp_string4 = "</textarea>\r\n					</div>\r\n					<div class=\"link\">\r\n						<label for=\"backlink\">\u9023\u7d50:</label><input type=\"text\" id=\"backlink\"\r\n							name='Link' ".toCharArray();
    _jsp_string6 = "\" ".toCharArray();
    _jsp_string8 = "\">\r\n					</div>\r\n					<button type=\"summit\">\u66f4\u65b0</button>\r\n				</div>\r\n				".toCharArray();
    _jsp_string5 = "\r\n							value=\"".toCharArray();
    _jsp_string3 = "\">\r\n					</div>\r\n					<div class=\"content\">\r\n						<label for=\"backcontent\">\u5167\u5bb9:</label>\r\n						<textarea id=\"backcontent\" rows=\"15\" cols=\"31\" name='Content'>".toCharArray();
    _jsp_string1 = "\r\n		<form action='updateNewsSave.jsp' method='post'>\r\n			<input type=\"hidden\" id=\"id\" name=\"id\" value=\"".toCharArray();
    _jsp_string7 = ">\r\n					</div>\r\n					<div class=\"img\">\r\n						<label for=\"backimg\">\u5716\u7247:</label><input type='file' id=\"backimg\"\r\n							name='upload' value=\"".toCharArray();
    _jsp_string2 = "\" />\r\n\r\n			<fieldset>\r\n				<legend>\u6700\u65b0\u6d88\u606f\u7dad\u8b77</legend>\r\n				<div id=\"addback\">\r\n					<div class=\"title\">\r\n						<label for=\"backtitle\">\u6a19\u984c:</label><input type=\"text\"\r\n							id=\"backtitle\" name='Subject' value=\"".toCharArray();
    _jsp_string9 = "\r\n			</fieldset>\r\n\r\n\r\n		</form>\r\n	</div>\r\n</body>\r\n</html>".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n<meta charset=\"UTF-8\">\r\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n<!-- \u8cc7\u6e90\u6a94 -->\r\n\r\n<title>\u53f0\u9435\u795e\u7968\u624b\u5f8c\u53f0</title>\r\n<link rel=\"shortcut icon\" href=\"image/logo.png\">\r\n<link rel=\"stylesheet\" href=\"css/screen.css\">\r\n<script\r\n	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n<script src=\"js/public.js\"></script>\r\n<link\r\n	href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css\"\r\n	rel=\"stylesheet\">\r\n<script type=\"text/javascript\"\r\n	src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js\"></script>\r\n<script src=\"js/datepicker.js\"></script>\r\n<!-- \u522a\u9664\u6307\u4ee4\u7528\u5230 -->\r\n<script type=\"text/javascript\" src=\"/js/jquery.form.js\"></script>\r\n\r\n</head>\r\n<body>\r\n	<div class=\"main\" id=\"main\">\r\n		".toCharArray();
  }
}
