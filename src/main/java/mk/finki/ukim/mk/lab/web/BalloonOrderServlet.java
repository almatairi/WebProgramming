package mk.finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="balloon-order", urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {
    SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext (req,resp,req.getServletContext ());
        springTemplateEngine.process ("deliveryInfo.html", context,resp.getWriter ());
        context.setVariable ("balloonColor", req.getSession().getAttribute ("color"));
        context.setVariable ("balloonSize", req.getSession ().getAttribute ("size"));
        this.springTemplateEngine.process ("deliveryInfo.html", context, resp.getWriter ());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter ("clientName");
        String clientAddress = req.getParameter ("clientAddress");
        req.getSession ().setAttribute ("name", clientName);
        req.getSession ().setAttribute ("address", clientAddress);
        resp.sendRedirect ("/ConfirmationInfo");
    }
}
