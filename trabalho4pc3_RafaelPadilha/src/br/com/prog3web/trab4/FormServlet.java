package br.com.prog3web.trab4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Resultado")
public class FormServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String nome,matricula,sexo;
		Integer idade;
		// pegando os valores de variáveis enviadas do cliente
		nome = req.getParameter("nome");
		matricula = req.getParameter("matricula");
		sexo = req.getParameter("sexo");
		idade = Integer.parseInt(req.getParameter("idade"));
		// imprime estes dados no cliente
		out.println("<HTML><HEAD><TITLE>Primeiro Servlet");
		out.println("</TITLE></HEAD><BODY>");
		out.println("<H1>Servlet com dados do form</H1>");
		out.println("<BR>Matricula :" + matricula +  "<br>"
				+ "Nome : " + nome + "<br>"
				+ "Idade : " + idade + "<br>"
				+ "Sexo : " + sexo + "<br>"
				+ "Mensagem :");
		if(sexo.equals("masculino")){
			if(idade>= 18)
				out.println("Você precisa servir ao exercito<br>");
			else if(idade < 18)
				out.println("Voce esta ok com as obrigacoes militares<br>");
		}
		else if(sexo.equals("feminino"))
			out.println("Voce nao precisar servir ao exercito<br>");
		out.println("<BR></BODY></HTML>");
		out.close();
	}
}