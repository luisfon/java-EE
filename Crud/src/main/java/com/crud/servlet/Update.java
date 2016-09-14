package com.crud.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.Usuarios;
import com.crud.org.Crud.Conexion;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Actualizar
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Conexion con=new Conexion();
		
		String id=request.getParameter("id");
		
		String sql="select*from datos where id=?";
		
		try 
		{
			
			PreparedStatement stm=(PreparedStatement) con.GetCon().prepareStatement(sql);
			stm.setString(1, id);
			
			ResultSet rs=stm.executeQuery();
		
			
			Usuarios usuario=new Usuarios();
			
			while(rs.next())
			{
				
				
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApp(rs.getString("app"));
				usuario.setEdad(rs.getInt("edad"));
			}
			
			rs.close();
			stm.close();
			
			
			request.setAttribute("usuario", usuario);
			
			request.getRequestDispatcher("update.jsp").forward(request, response);
			
			
			
		} catch (SQLException e)
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		Conexion con=new Conexion();
		
	    String id=request.getParameter("id");
	    String nom=request.getParameter("nombre");
	    String app=request.getParameter("app");
	    String edad1=request.getParameter("edad");
	    int edad=Integer.parseInt(edad1);
	     
	    String sql="update datos set nombre=?,app=?,edad=?  where id=?";
	    
	    try 
	    {
			PreparedStatement stm=(PreparedStatement) con.GetCon().prepareStatement(sql);
			
			stm.setString(1,nom );
			stm.setString(2, app);
			stm.setInt(3, edad);
			stm.setString(4, id);
			
			stm.executeUpdate();
			stm.close();
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} catch (SQLException e) 
	    {
			System.out.println(e);
		}
	    finally {
			con.CloseCon();
		}
	  
        
	

		
	}

}
