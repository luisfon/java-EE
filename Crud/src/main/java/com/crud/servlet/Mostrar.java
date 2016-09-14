package com.crud.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.Usuarios;
import com.crud.org.Crud.Conexion;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Mostrar
 */
public class Mostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mostrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		Conexion con=new Conexion();
		
		
		String sql="select*from datos";
		
		try 
		{
			 PreparedStatement stm=(PreparedStatement) con.GetCon().prepareStatement(sql);
			 
			 ResultSet rs=stm.executeQuery();
			 
			 List<Usuarios>listaUsuario=new ArrayList<Usuarios>();
			 
		while (rs.next()) 
		 {
			Usuarios usuario=new Usuarios();
			
			usuario.setId(rs.getInt("id"));	
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApp(rs.getString("app"));
			usuario.setEdad(rs.getInt("edad"));
			
			listaUsuario.add(usuario);
		 }
		
		rs.close();
		stm.close();
		
		
		 request.setAttribute("usuarios", listaUsuario);
	     
			request.getRequestDispatcher("mostrar.jsp").forward(request, response);
			 
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
