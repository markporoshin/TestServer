package server.servlets

import server.PageGenerator
import units.user.UserManagerImpl
import java.util.HashMap
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by Mark on 11.07.2017.
 */
class AuthoServlet: HttpServlet{
    var um: UserManagerImpl
    constructor(um: UserManagerImpl){
        this.um = um
    }

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val pageVariables: HashMap<String, Any> = createPageVariablesMap(req!!)
        var session = pageVariables.get("sessionId").toString()

        resp!!.contentType = "text/html;charset=utf-8"
        resp.writer.println(PageGenerator.instance().getPage("autho/autho.html", pageVariables))
}
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val pageVariables: HashMap<String, Any> = createPageVariablesMap(req!!)
        var session = pageVariables.get("sessionId").toString()

        resp!!.contentType = "text/html;charset=utf-8"
        val login = req.getParameter("login").toString()
        val pass = req.getParameter("password").toString()
        if(um.check(login, pass)){
            pageVariables.put("title", "it's okey")
            pageVariables.put("message", "Good, your input true login and password")
        }else{
            pageVariables.put("title", "some problems")
            pageVariables.put("message", "Sorry man, but your login and password is incorrect")
        }
        resp.writer.println(PageGenerator.instance().getPage("autho/autho_ok.html", pageVariables))
    }

    private fun createPageVariablesMap(request: HttpServletRequest): HashMap<String, Any> {
        val pageVariables = HashMap<String, Any>()
        pageVariables.put("method", request.method)
        pageVariables.put("URL", request.requestURL.toString())
        pageVariables.put("pathInfo", request.pathInfo)
        pageVariables.put("sessionId", request.session.id)
        pageVariables.put("parameters", request.parameterMap.toString())
        return pageVariables
    }
}