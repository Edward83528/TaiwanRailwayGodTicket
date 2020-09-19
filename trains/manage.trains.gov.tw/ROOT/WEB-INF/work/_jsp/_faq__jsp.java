/*
 * JSP generated by Resin Professional 4.0.53 (built Fri, 16 Jun 2017 02:25:02 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import tw.com.common.*;
import java.util.*;

public class _faq__jsp extends com.caucho.jsp.JavaPage
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

		String keyword = (String) request.getParameter("keyword");
		if (keyword == null || keyword.equals("null") || keyword.lastIndexOf("\u8acb\u8f38\u5165") != -1) {
			keyword = "";
		}
		String from = (String) request.getParameter("from");
		if (from == null || from.equals("null")) {
			from = SysUtil.nowDate("yyyy-MM-dd");
		}
		String to = (String) request.getParameter("to");
		if (to == null || to.equals("null")) {
			to = SysUtil.nowDate("yyyy-MM-dd");
		}
	
    out.write(_jsp_string1, 0, _jsp_string1.length);
    
									TrainData trainDate = new TrainData();
									ArrayList<FAQiItem> lists = trainDate.SelectFAQs(keyword);
									if (lists != null) {
										for (int i = 0; i < lists.size(); i++) {
											FAQiItem list = lists.get(i);
								
    out.write(_jsp_string2, 0, _jsp_string2.length);
    out.print((list.getId()));
    out.write(_jsp_string3, 0, _jsp_string3.length);
    out.print((i + 1));
    out.write(_jsp_string4, 0, _jsp_string4.length);
    out.print((list.getId()));
    out.write(_jsp_string5, 0, _jsp_string5.length);
    out.print((list.getQuestion()));
    out.write(_jsp_string6, 0, _jsp_string6.length);
    
									}
									}
								
    out.write(_jsp_string7, 0, _jsp_string7.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("FAQ.jsp"), 3627739669924982749L, false);
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

  private final static char []_jsp_string6;
  private final static char []_jsp_string7;
  private final static char []_jsp_string2;
  private final static char []_jsp_string5;
  private final static char []_jsp_string1;
  private final static char []_jsp_string4;
  private final static char []_jsp_string0;
  private final static char []_jsp_string3;
  static {
    _jsp_string6 = "</a></td>\r\n\r\n								</tr>\r\n\r\n								".toCharArray();
    _jsp_string7 = "\r\n\r\n\r\n							</tbody>\r\n						</table>\r\n\r\n					</div>\r\n				</div>\r\n			</fieldset>\r\n		</div>\r\n	</form>\r\n</body>\r\n</html>".toCharArray();
    _jsp_string2 = "\r\n								<tr>\r\n									<td><input type=\"checkbox\" name=\"check\" id=\"check\"\r\n										value=\"".toCharArray();
    _jsp_string5 = "\"> ".toCharArray();
    _jsp_string1 = "\r\n\r\n	<form method='post' name=\"mform\" id=\"mform\">\r\n		<div class=\"main\" id=\"main\">\r\n			<fieldset>\r\n				<legend>\u554f\u8207\u7b54\u7dad\u8b77</legend>\r\n				<div id=\"backnews\">\r\n					<div class=\"key\">\r\n						<label for=\"keyword\">\u95dc\u9375\u5b57:</label><input type=\"text\" id=\"keyword\"\r\n							name=\"keyword\" value=\"\u8acb\u8f38\u5165\u95dc\u9375\u5b57\"\r\n							onFocus=\"javascript: if (this.value=='\u8acb\u8f38\u5165\u95dc\u9375\u5b57') this.value='';\"\r\n							onBlur=\"javascript: if(this.value=='') this.value='\u8acb\u8f38\u5165\u95dc\u9375\u5b57';\">\r\n					</div>\r\n\r\n					<div class=\"btn\">\r\n						<button type=\"button\" onclick=\"javascript:save()\">\u65b0\u589e</button>\r\n						<button type=\"button\" id=\"del\">\u522a\u9664</button>\r\n						<button type=\"button\" onclick=\"javascript:clean()\">\u6e05\u7a7a</button>\r\n						<button type=\"button\" onclick=\"javascript:select()\">\u67e5\u8a62</button>\r\n\r\n					</div>\r\n					<div class=\"backtable\">\r\n						<table>\r\n							<thead>\r\n								<tr>\r\n									<th>\u522a\u9664</th>\r\n									<th>\u9806\u5e8f</th>\r\n									<th>\u554f\u984c</th>\r\n								</tr>\r\n							</thead>\r\n							<tbody>\r\n								".toCharArray();
    _jsp_string4 = "</td>\r\n									<td><a href=\"FAQUpdate.jsp?id=".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n<meta charset=\"UTF-8\">\r\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n<!-- \u8cc7\u6e90\u6a94 -->\r\n\r\n<title>\u53f0\u9435\u795e\u7968\u624b\u5f8c\u53f0</title>\r\n<link rel=\"shortcut icon\" href=\"image/logo.png\">\r\n<link rel=\"stylesheet\" href=\"css/screen.css\">\r\n<script\r\n	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n<script src=\"js/public.js\"></script>\r\n<link\r\n	href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css\"\r\n	rel=\"stylesheet\">\r\n<script type=\"text/javascript\"\r\n	src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js\"></script>\r\n<script src=\"js/datepicker.js\"></script>\r\n<!-- \u522a\u9664\u6307\u4ee4\u7528\u5230 -->\r\n<script type=\"text/javascript\" src=\"/js/jquery.form.js\"></script>\r\n\r\n<script type=\"text/javascript\">\r\n	function save() {\r\n		document.mform.action = \"FAQAdd.jsp\";\r\n		document.mform.method = \"post\";\r\n		document.mform.submit();\r\n	}\r\n	$(document).ready(function() {\r\n		$('#del').click(function() {\r\n			x = window.confirm(\"\u78ba\u5b9a\u57f7\u884c\u522a\u9664\u55ce?\");\r\n			if (x) {\r\n				var options = {\r\n					url : \"deleteFAQ.jsp\",\r\n					type : \"POST\",\r\n					success : function(msg) {\r\n						delmessage(msg);\r\n					}\r\n				};\r\n				$('#mform').ajaxSubmit(options);\r\n			}\r\n		});\r\n	});\r\n\r\n	function delmessage(msg) {\r\n\r\n		ary_msg = msg.split(\"||\");\r\n		if (ary_msg[1] != 'true') {\r\n			var showAlert = \"\u522a\u9664\u5931\u6557\uff01\" + ary_msg[2];\r\n			alert(showAlert);\r\n		} else {\r\n			var showAlert = \"\u522a\u9664\u6210\u529f\uff01\";\r\n			alert(showAlert);\r\n		}\r\n		document.mform.action = \"FAQ.jsp\";\r\n		document.mform.method = \"post\";\r\n		document.mform.submit();\r\n	}\r\n\r\n	function select() {\r\n\r\n		document.mform.action = \"FAQ.jsp\";\r\n		document.mform.method = \"post\";\r\n		document.mform.submit();\r\n	}\r\n	function clean() {\r\n		document.getElementById(\"from\").value = \"\";\r\n		document.getElementById(\"to\").value = \"\";\r\n	}\r\n</script>\r\n</head>\r\n<body>\r\n	".toCharArray();
    _jsp_string3 = "\" /></td>\r\n									<td>".toCharArray();
  }
}
