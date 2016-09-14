package com.crud.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.org.Crud.Conexion;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Eliminar
 */
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Conexion con=new Conexion();
	
		String id=request.getParameter("id");
		
		String sql="delete from datos where id=?";
		
		try {
			PreparedStatement stm=(PreparedStatement) con.GetCon().prepareStatement(sql);
			stm.setString(1, id);
			stm.execute();
			
			request.getRequestDispatcher("eliminar.jsp").forward(request, response);
		}
		catch (SQLException e) 
		{
			System.out.println(e);
		}
		finally {
			con.CloseCon();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
