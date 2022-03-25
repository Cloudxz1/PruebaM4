package pruebaM4;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class PruebaM4Servlet
 */
@WebServlet("/PruebaM4Servlet")
public class PruebaM4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PruebaM4Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conex;
		conex = ConnectionBD.ConexionMySQL();
		TitleTypes title;
		String resp = "";
		switch(request.getParameter("operation")) {
		case "insert":
			if(TitleTypesCRUD.InsertTitle(conex, new TitleTypes(Integer.parseInt(request.getParameter("title_no")), request.getParameter("title")))) {
				resp = "Exito";
			}
			break;
		case "select":
			title = TitleTypesCRUD.SelectTitle(conex, Integer.parseInt(request.getParameter("title_no")));
			resp = title.getTitle_no()+ ";" + title.getTitle();
			break;
		case "delete":
			if(TitleTypesCRUD.DeleteTitle(conex, Integer.parseInt(request.getParameter("title_no")))) {
				resp = "Eliminado";
			}
			break;
		case "update":
			
			if(TitleTypesCRUD.UpdateTitles(conex,new TitleTypes(Integer.parseInt(request.getParameter("title_no")), request.getParameter("title")))) {
			resp = "Exito";
			}
			break;
		}
		response.getWriter().append(resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
