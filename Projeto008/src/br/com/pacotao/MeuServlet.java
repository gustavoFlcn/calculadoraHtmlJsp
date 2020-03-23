package br.com.pacotao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcular")
public class MeuServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String numero1 = req.getParameter("numero1");
		String numero2 = req.getParameter("numero2");
		String operador = req.getParameter("operador");
		
		float value1 = Float.parseFloat(numero1);
		float value2 = Float.parseFloat(numero2);
		float resultado = (float) 0.0;
		
		
		switch (operador) {
		case "+":
			resultado = value1 + value2;
			break;
		case "-":
			resultado = value1 - value2;
			break;
		case "*":
			resultado = value1 * value2;
			break;
		case "/":
			resultado = value1 / value2;
			break;
		default:
			resultado = -1;
			break;
		}
		req.setAttribute("resultado", resultado);
		req.getRequestDispatcher("recebeDados.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.htm");
		super.doGet(req, resp);
	}
}
