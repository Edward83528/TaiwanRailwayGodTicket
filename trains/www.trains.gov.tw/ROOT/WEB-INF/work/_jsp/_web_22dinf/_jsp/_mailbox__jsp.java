/*
 * JSP generated by Resin Professional 4.0.53 (built Fri, 16 Jun 2017 02:25:02 PDT)
 */

package _jsp._web_22dinf._jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import tw.com.common.*;

public class _mailbox__jsp extends com.caucho.jsp.JavaPage
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
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, "/error.jsp", session, 8192, true, false);

    TagState _jsp_state = new TagState();

    try {
      _jspService(request, response, pageContext, _jsp_application, session, _jsp_state);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_state.release();
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
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jsp_UrlTag_0 = null;
    org.springframework.web.servlet.tags.form.FormTag _jsp_FormTag_1 = null;

    out.write(_jsp_string0, 0, _jsp_string0.length);
    _jsp_UrlTag_0 = _jsp_state.get_jsp_UrlTag_0(pageContext, _jsp_parent_tag);
    _jsp_UrlTag_0.setValue("/js/bootstrap/css/bootstrap.min.css");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string1, 0, _jsp_string1.length);
    _jsp_UrlTag_0.setValue("/css/main.css");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string2, 0, _jsp_string2.length);
    _jsp_UrlTag_0.setValue("/js/bootstrap/js/jquery.js");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string3, 0, _jsp_string3.length);
    _jsp_UrlTag_0.setValue("/js/bootstrap/js/bootstrap.min.js");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string3, 0, _jsp_string3.length);
    _jsp_UrlTag_0.setValue("/js/onload.js");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string3, 0, _jsp_string3.length);
    _jsp_UrlTag_0.setValue("/js/public.js");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string3, 0, _jsp_string3.length);
    _jsp_UrlTag_0.setValue("/js/animate.js");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string4, 0, _jsp_string4.length);
    _jsp_UrlTag_0.setValue("/image/logo.png");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string5, 0, _jsp_string5.length);
    _jsp_UrlTag_0.setValue("/js/camera/css/camera.css");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string6, 0, _jsp_string6.length);
    _jsp_UrlTag_0.setValue("/js/camera/scripts/jquery.easing.1.3.js");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string7, 0, _jsp_string7.length);
    _jsp_UrlTag_0.setValue("/js/camera/scripts/camera.min.js");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string8, 0, _jsp_string8.length);
    _jsp_UrlTag_0.setValue("/image/anilogo.png");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string9, 0, _jsp_string9.length);
    _jsp_UrlTag_0.setValue("/image/logo.png");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string10, 0, _jsp_string10.length);
    _jsp_FormTag_1 = _jsp_state.get_jsp_FormTag_1(pageContext, _jsp_parent_tag);
    javax.servlet.jsp.JspWriter _jsp_writer55 = out;
    try {
      int _jspEval56 = _jsp_FormTag_1.doStartTag();
      if (_jspEval56 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write(_jsp_string11, 0, _jsp_string11.length);
      }
      _jsp_FormTag_1.doEndTag();
    } catch (Throwable _jsp_exn_58) {
      pageContext.setWriter(_jsp_writer55);
      out = _jsp_writer55;
      _jsp_FormTag_1.doCatch(_jsp_exn_58);
    } finally {
      _jsp_FormTag_1.doFinally();
    }
    out.write(_jsp_string12, 0, _jsp_string12.length);
    _jsp_UrlTag_0.setValue("/image/footer.png");
    _jsp_UrlTag_0.doStartTag();
    _jsp_UrlTag_0.doEndTag();
    out.write(_jsp_string13, 0, _jsp_string13.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/jsp/mailbox.jsp"), 1152138714705783985L, false);
    _caucho_depends.add(depend);
    loader.addDependency(depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("include/resources.jsp"), -8901186339887637670L, false);
    _caucho_depends.add(depend);
    loader.addDependency(depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("include/home_menu.jsp"), 3973236757789456302L, false);
    _caucho_depends.add(depend);
    loader.addDependency(depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("include/foot.jsp"), 7814668461073147917L, false);
    _caucho_depends.add(depend);
    loader.addDependency(depend);
    depend = new com.caucho.vfs.Depend(mergePath.lookup("jar:file:/d:/webapps/trains/www.trains.gov.tw/ROOT/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld"), 838717489254745285L, false);
    _caucho_depends.add(depend);
    loader.addDependency(depend);
    _caucho_depends.add(new com.caucho.make.ClassDependency("org.apache.taglibs.standard.tag.rt.core.UrlTag", 7273893370556831084L));
    depend = new com.caucho.vfs.Depend(mergePath.lookup("jar:file:/d:/webapps/trains/www.trains.gov.tw/ROOT/WEB-INF/lib/spring-webmvc-4.3.6.RELEASE-sources.jar!/META-INF/spring-form.tld"), -1474752977240154878L, false);
    _caucho_depends.add(depend);
    loader.addDependency(depend);
    _caucho_depends.add(new com.caucho.make.ClassDependency("org.springframework.web.servlet.tags.form.FormTag", 2028007188778282940L));
  }

  static {
    try {
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  final static class TagState {
    private org.apache.taglibs.standard.tag.rt.core.UrlTag _jsp_UrlTag_0;

    final org.apache.taglibs.standard.tag.rt.core.UrlTag get_jsp_UrlTag_0(PageContext pageContext, javax.servlet.jsp.tagext.JspTag _jsp_parent_tag) throws Throwable
    {
      if (_jsp_UrlTag_0 == null) {
        _jsp_UrlTag_0 = new org.apache.taglibs.standard.tag.rt.core.UrlTag();
        _jsp_UrlTag_0.setPageContext(pageContext);
        if (_jsp_parent_tag instanceof javax.servlet.jsp.tagext.Tag)
          _jsp_UrlTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jsp_parent_tag);
        else if (_jsp_parent_tag instanceof javax.servlet.jsp.tagext.SimpleTag)
          _jsp_UrlTag_0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) _jsp_parent_tag));
        else
          _jsp_UrlTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      return _jsp_UrlTag_0;
    }
    private org.springframework.web.servlet.tags.form.FormTag _jsp_FormTag_1;

    final org.springframework.web.servlet.tags.form.FormTag get_jsp_FormTag_1(PageContext pageContext, javax.servlet.jsp.tagext.JspTag _jsp_parent_tag) throws Throwable
    {
      if (_jsp_FormTag_1 == null) {
        _jsp_FormTag_1 = new org.springframework.web.servlet.tags.form.FormTag();
        _jsp_FormTag_1.setPageContext(pageContext);
        if (_jsp_parent_tag instanceof javax.servlet.jsp.tagext.Tag)
          _jsp_FormTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jsp_parent_tag);
        else if (_jsp_parent_tag instanceof javax.servlet.jsp.tagext.SimpleTag)
          _jsp_FormTag_1.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) _jsp_parent_tag));
        else
          _jsp_FormTag_1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_FormTag_1.setMethod("POST");
        _jsp_FormTag_1.setAction("/HelloWeb/send");
        _jsp_FormTag_1.setName("mform");
        _jsp_FormTag_1.setId("mform");
        _jsp_FormTag_1.setDynamicAttribute("", "class", "mail");
      }

      return _jsp_FormTag_1;
    }

    void release()
    {
      if (_jsp_UrlTag_0 != null) {
        _jsp_UrlTag_0.release();
        _jsp_UrlTag_0 = null;
      }
      if (_jsp_FormTag_1 != null) {
        _jsp_FormTag_1.release();
        _jsp_FormTag_1 = null;
      }
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
      manager.addTaglibFunctions(_jsp_functionMap, "c", "http://java.sun.com/jsp/jstl/core");
      manager.addTaglibFunctions(_jsp_functionMap, "form", "http://www.springframework.org/tags/form");
      com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.InitPageContextImpl(webApp, this);
    } catch (Exception e) {
      throw com.caucho.config.ConfigException.create(e);
    }
  }

  private final static char []_jsp_string6;
  private final static char []_jsp_string8;
  private final static char []_jsp_string1;
  private final static char []_jsp_string2;
  private final static char []_jsp_string13;
  private final static char []_jsp_string7;
  private final static char []_jsp_string12;
  private final static char []_jsp_string9;
  private final static char []_jsp_string3;
  private final static char []_jsp_string0;
  private final static char []_jsp_string11;
  private final static char []_jsp_string5;
  private final static char []_jsp_string4;
  private final static char []_jsp_string10;
  static {
    _jsp_string6 = "\">\r\n<script type=\"text/javascript\"\r\n	src=\"".toCharArray();
    _jsp_string8 = "\"></script>\r\n\r\n\r\n<script type=\"text/javascript\">\r\n	function save() {\r\n		if (document.getElementById(\"name\").value == ''\r\n				|| document.getElementById(\"name\").value.indexOf(\"\u8acb\u8f38\u5165\u59d3\u540d\") >= 0) {\r\n			alert(\"\u8acb\u8f38\u5165\u59d3\u540d\");\r\n			document.getElementById(\"name\").focus();\r\n			return;\r\n		}\r\n		if (document.getElementById(\"phone\").value == ''\r\n				|| document.getElementById(\"phone\").value.indexOf(\"\u8acb\u8f38\u5165\u9023\u7d61\u96fb\u8a71\") >= 0) {\r\n			alert(\"\u8acb\u8f38\u5165\u9023\u7d61\u96fb\u8a71\");\r\n			document.getElementById(\"phone\").focus();\r\n			return;\r\n		}\r\n		if (document.getElementById(\"email\").value == ''\r\n				|| document.getElementById(\"email\").value.indexOf(\"\u8acb\u8f38\u5165E-mail\") >= 0) {\r\n			alert(\"\u8acb\u8f38\u5165E-mail\");\r\n			document.getElementById(\"email\").focus();\r\n			return;\r\n		}\r\n		if (document.getElementById(\"subject\").value == ''\r\n				|| document.getElementById(\"subject\").value.indexOf(\"\u8acb\u8f38\u5165\u4e3b\u65e8\") >= 0) {\r\n			alert(\"\u8acb\u8f38\u5165\u4e3b\u65e8\");\r\n			document.getElementById(\"subject\").focus();\r\n			return;\r\n		}\r\n\r\n		document.mform.action = \"/HelloWeb/send\";\r\n		document.mform.method = \"post\";\r\n		document.mform.submit();\r\n	}\r\n</script>\r\n</head>\r\n<body>\r\n	<div class=\"anibg\">\r\n		<img src=\"".toCharArray();
    _jsp_string1 = "\">\r\n<link rel=\"stylesheet\" href=\"".toCharArray();
    _jsp_string2 = "\">\r\n<script src=\"".toCharArray();
    _jsp_string13 = "\">\r\n\r\n\r\n\r\n\r\n\r\n		</div>\r\n\r\n\r\n	</div>\r\n</body>\r\n</html>".toCharArray();
    _jsp_string7 = "\"></script>\r\n<script type=\"text/javascript\"\r\n	src=\"".toCharArray();
    _jsp_string12 = "\r\n						</div>\r\n\r\n					</div>\r\n\r\n				</div>\r\n			</div>\r\n\r\n\r\n			<!-- pagefooter -->\r\n\r\n			<div class=\"container\">\r\n	<footer>\r\n		<div class=\"up\">\r\n			<p>\u53f0\u9435\u795e\u7968\u624b\u958b\u767c\u4eba\u54e1</p>\r\n			<p>\u7d44\u54e1:</p>\r\n			<p class=\"name\">\u5f35\u4ef2\u5a01&nbsp; Email:u0151051@gmail.com &nbsp;</p>\r\n			<p class=\"name\">\u674e\u8aa0\u7950\u0090&nbsp; Email:tim0910959515@gmail.com&nbsp;</p>\r\n			<p class=\"name\">\u5433\u4fca\u9038&nbsp; Email:49754916@stust.edu.tw &nbsp;</p>\r\n		</div>\r\n		<div class=\"down\">\r\n			<p>*\u672c\u7db2\u7ad9\u82e5\u6709\u4e0d\u614e\u5f15\u7528\u60a8\u7684\u5716\u6587\u8cc7\u6599\uff0c\u4fb5\u72af\u5230\u60a8\u7684\u8457\u4f5c\u6b0a\uff0c\u656c\u8acb\u544a\u77e5\u5c07\u7acb\u5373\u522a\u9664\uff0c\u8b1d\u8b1d\uff01*</p>\r\n		</div>\r\n	</footer>\r\n</div>\r\n<img id=\"fbackground\" src=\"".toCharArray();
    _jsp_string9 = "\">\r\n		<div class=\"backA\"></div>\r\n		<div class=\"backB\"></div>\r\n	</div>\r\n	<div id=\"all\">\r\n		<div id=\"topbackgroundMail\">\r\n\r\n			<!-- \u5c0e\u89bd\u5217 \u4e0a\u65b9\u5716\u7247-->\r\n\r\n			\r\n<!-- \u4e0a\u65b9\u5716\u7247 -->\r\n<div class=\"container\">\r\n	<div id=\"camera_wrap\">\r\n		<div data-src=\"../image/banner-train0.jpg\">\r\n			<div class=\"camera_caption fadeFromBottom\">\u5340\u9593\u8eca</div>\r\n		</div>\r\n		<div data-src=\"../image/banner-train1.jpg\">\r\n			<div class=\"camera_caption fadeFromBottom\">\u666e\u60a0\u746a\u865f</div>\r\n		</div>\r\n		<div data-src=\"../image/banner-train2.jpg\">\r\n			<div class=\"camera_caption fadeFromBottom\">\u81ea\u5f37\u865f</div>\r\n		</div>\r\n		<div data-src=\"../image/banner-train3.jpg\">\r\n			<div class=\"camera_caption fadeFromBottom\">\u592a\u9b6f\u95a3\u865f</div>\r\n		</div>\r\n		<div data-src=\"../image/banner-train4.jpg\">\r\n			<div class=\"camera_caption fadeFromBottom\">\u8392\u5149\u865f</div>\r\n		</div>\r\n	</div>\r\n</div>\r\n\r\n\r\n\r\n<div class=\"container\">\r\n	<nav class=\"navbar navbar-default navbar-static-top\">\r\n		<div class=\"container\">\r\n			<div class=\"navbar-header\">\r\n				<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\"\r\n					data-target=\"#myNavbar\">\r\n					<span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n						class=\"icon-bar\"></span>\r\n				</button>\r\n				<a class=\"navbar-brand\" href=\"../index.jsp\"> <img id=\"logo\"\r\n					src=\" ".toCharArray();
    _jsp_string3 = "\"></script>\r\n<script src=\"".toCharArray();
    _jsp_string0 = "\r\n<!DOCTYPE html>\r\n\r\n\r\n\r\n<html lang=\"en\">\r\n<head>\r\n<meta charset=\"UTF-8\">\r\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n<title>\u53f0\u9435\u795e\u7968\u624b</title>\r\n<!-- \u8cc7\u6e90\u6a94 -->\r\n\r\n<link rel=\"stylesheet\"\r\n	href=\"".toCharArray();
    _jsp_string11 = "\r\n								<div class=\"row\">\r\n									<div class=\"col-md-3\">\r\n										<label class=\"control-label\">\u59d3\u540d:</label>\r\n									</div>\r\n									<div class=\"col-md-9\">\r\n										<input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\"\r\n											value=\"\u8acb\u8f38\u5165\u59d3\u540d\"\r\n											onFocus=\"javascript: if (this.value=='\u8acb\u8f38\u5165\u59d3\u540d') this.value='';\"\r\n											onBlur=\"javascript: if(this.value=='') this.value='\u8acb\u8f38\u5165\u59d3\u540d';\" />\r\n									</div>\r\n								</div>\r\n								<div class=\"row\">\r\n									<div class=\"col-md-3\">\r\n										<label class=\"control-label\">\u9023\u7d61\u96fb\u8a71:</label>\r\n									</div>\r\n									<div class=\"col-md-9\">\r\n										<input type=\"text\" id=\"phone\" name=\"phone\"\r\n											class=\"form-control\" value=\"\u8acb\u8f38\u5165\u9023\u7d61\u96fb\u8a71\"\r\n											onFocus=\"javascript: if (this.value=='\u8acb\u8f38\u5165\u9023\u7d61\u96fb\u8a71') this.value='';\"\r\n											onBlur=\"javascript: if(this.value=='') this.value='\u8acb\u8f38\u5165\u9023\u7d61\u96fb\u8a71';\" />\r\n									</div>\r\n								</div>\r\n								<div class=\"row\">\r\n									<div class=\"col-md-3\">\r\n										<label class=\"control-label\">E-mail:</label>\r\n									</div>\r\n									<div class=\"col-md-9\">\r\n										<input type=\"text\" id=\"email\" name=\"email\"\r\n											class=\"form-control\" value=\"\u8acb\u8f38\u5165E-mail\"\r\n											onFocus=\"javascript: if (this.value=='\u8acb\u8f38\u5165E-mail') this.value='';\"\r\n											onBlur=\"javascript: if(this.value=='') this.value='\u8acb\u8f38\u5165E-mail';\" />\r\n									</div>\r\n								</div>\r\n								<div class=\"row\">\r\n									<div class=\"col-md-3\">\r\n										<label class=\"control-label\">\u4e3b\u65e8:</label>\r\n									</div>\r\n									<div class=\"col-md-9\">\r\n										<input type=\"text\" id=\"subject\" name=\"subject\"\r\n											class=\"form-control\" value=\"\u8acb\u8f38\u5165\u4e3b\u65e8\"\r\n											onFocus=\"javascript: if (this.value=='\u8acb\u8f38\u5165\u4e3b\u65e8') this.value='';\"\r\n											onBlur=\"javascript: if(this.value=='') this.value='\u8acb\u8f38\u5165\u4e3b\u65e8';\" />\r\n									</div>\r\n								</div>\r\n								<div class=\"row\">\r\n									<div class=\"col-md-3\">\r\n										<label class=\"control-label\">\u7559\u8a00:</label>\r\n									</div>\r\n									<div class=\"col-md-9\">\r\n										<textarea id=\"content\" name=\"content\" class=\"form-control\"\r\n											rows=\"5\" value=\"\u8acb\u8f38\u5165\u7559\u8a00\"\r\n											onFocus=\"javascript: if (this.value=='\u8acb\u8f38\u5165\u7559\u8a00') this.value='';\"\r\n											onBlur=\"javascript: if(this.value=='') this.value='\u8acb\u8f38\u5165\u7559\u8a00';\"></textarea>\r\n									</div>\r\n								</div>\r\n								<div class=\"btnout\">\r\n									<button type=\"button\" class=\"btn btn-success\"\r\n										onclick=\"javascript:save()\">\u5bc4\u4fe1</button>\r\n								</div>\r\n							".toCharArray();
    _jsp_string5 = "\">\r\n<link rel=\"stylesheet\"\r\n	href=\"".toCharArray();
    _jsp_string4 = "\"></script>\r\n<link rel=\"shortcut icon\" href=\"".toCharArray();
    _jsp_string10 = "\"><span>\u53f0\u9435\u795e\u7968\u624b</span>\r\n				</a>\r\n			</div>\r\n			<div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n				<ul class=\"nav navbar-nav\">\r\n					<li><a href=\"/HelloWeb/order1\">\u5feb\u901f\u8a02\u7968</a></li>\r\n					<li><a href=\"/HelloWeb/search1\">\u67e5\u8a62\u7cfb\u7d71</a></li>\r\n					<li><a href=\"/HelloWeb/refund1\">\u53d6\u6d88\u8a02\u7968</a></li>\r\n					<li><a href=\"/HelloWeb/Found?start=1\">\u5c0b\u627e\u8eca\u7ad9</a></li>\r\n					<li><a href=\"/HelloWeb/Email\">\u5c40\u9577\u4fe1\u7bb1</a></li>\r\n					<li><a href=\"/HelloWeb/more?start=1\">\u6700\u65b0\u6d88\u606f</a></li>\r\n					<li><a href=\"/HelloWeb/morefaq?start=1\">\u5e38\u898b\u554f\u7b54</a></li>\r\n\r\n				</ul>\r\n			</div>\r\n		</div>\r\n	</nav>\r\n</div>\r\n\r\n\r\n\r\n			<div id=\"mail\">\r\n				<div class=\"container\">\r\n\r\n					<div class=\"mailbg\">\r\n\r\n						<h3>\u5c40\u9577\u4fe1\u7bb1</h3>\r\n						<div class=\"innerMail\">\r\n							<div class=\"back\"></div>\r\n							".toCharArray();
  }
}
