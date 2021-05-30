package ca.limin.dbtest;//package ca.masoud.dbtest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/student_tracker")

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response)
						 throws ServletException, IOException {
		String user = "root";
		String pass = "root";
		String jdbcUrl = "jdbc:mysql://localhost:3306/travel_records?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("SUCCESS!!!");
			myConn.close();
		}
		catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}
}