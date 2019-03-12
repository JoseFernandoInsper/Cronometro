package br.edu.insper;

import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.DAO;

/**
 * Servlet implementation class Cria
 */
@WebServlet("/Cria")
public class Cria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cria() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("entrei no service");
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form action ='/cronometro/Cria' method='POST'>");
		out.println("Hora: <input type='text' name='hora'><br>");
		out.println("Minuto: <input type='text' name='minuto'><br>");
		out.println("Segundo: <input type='text' name='segundo'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("<a href='http://localhost:8081/cronometro/'>Pagina inicial</a>");
		out.println("</form>");
		out.println("</body></html>");
	}
	

		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entrei no post");
		try {
		
			DAO dao = new DAO();
			
			Dados dado = new Dados();
			dado.setHora(Integer.valueOf(request.getParameter("hora")));
			dado.setMinuto(Integer.valueOf(request.getParameter("minuto")));
			dado.setSegundo(Integer.valueOf(request.getParameter("segundo")));
			
			dao.adiciona(dado);
			
			
			
			int H = dado.getHora();
			int M = dado.getMinuto();
			int S = dado.getSegundo();
			
			double Ht = H*1000*60*60;
			double Mt = M*1000*60;
			double St = S*1000;
			
			double crono = Ht+Mt+St;
			double countDownDate = new Date().getTime();
			double tudo = crono + countDownDate;
			
	        
	        
	        PrintWriter out = response.getWriter();
	        out.println("<html><body>");
	        out.println("<head>");
	        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
	        out.println("<style>");
	        out.println("p {");
	        out.println("text-align: center;");
	        out.println("font-size: 60px;");
	        out.println("margin-top: 0px;");
	        out.println("}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<p id='demo'></p>");
	        
	        out.println("<script>");
	        out.println("var countDownDate = "+tudo+";");
	        out.println("var x = setInterval(function() {");	    
	        out.println("var now = new Date().getTime();");
	        out.println("var distance = countDownDate - now;");
	        
	        out.println("var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));");
	        out.println("var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));");
	        out.println("var seconds = Math.floor((distance % (1000 * 60)) / 1000);");
	         
	        out.println("document.getElementById('demo').innerHTML = hours + 'h ' + minutes + 'm ' + seconds + 's ';");
	         
	        out.println("if (distance < 0) {");
	        out.println("clearInterval(x);");
	        out.println("document.getElementById('demo').innerHTML = 'ACABOU O TEMPO!';");
	        out.println("}");
	        out.println("}, 1000);");
	        out.println("</script>");
	        out.println("<a href='http://localhost:8081/cronometro/'>Pagina inicial</a>");
	        out.println("</body>");
	        out.println("</html>");
	        
			
			dao.close();
			

			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
