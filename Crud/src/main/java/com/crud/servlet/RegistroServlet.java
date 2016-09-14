package com.crud.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.org.Crud.Conexion;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("registro.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		Conexion con=new Conexion();
		
		String sql="insert into datos(nombre,app,edad)values(?,?,?)";
		
		try {
			
			PreparedStatement stm=con.GetCon().prepareStatement(sql);
			
			stm.setString(1, request.getParameter("nombre"));
			stm.setString(2, request.getParameter("app"));
			stm.setInt(3, Integer.parseInt(request.getParameter("edad")));
			
			stm.execute();
			stm.close();
			con.CloseCon();
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} 
		catch (SQLException e)
		{
			System.out.println(e);
		}
	
	}

}
