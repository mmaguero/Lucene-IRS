package engine;

import java.io.File;
import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import document.MyFile;

/**
 * Servlet implementation class searchForm
 */
@WebServlet(description = "Search Form Lucene IRS", urlPatterns = { "/searchForm" })
public class searchForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<MyFile> items;
	String message, error = "An exception was ocurred. Please try again or send to the admin@mail.com this: ";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Result.jsp");

		ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);

		MyFile.stopWordsFileName = "";
		MyFile.stopWordsFileName = contextPath + File.separator + "data" + File.separator + "palabras_vacias_utf8.txt";
		MyFile.indexDirectoryName = "";
		MyFile.indexDirectoryName = contextPath + File.separator + "data" + File.separator + "indexes" + File.separator;

		try {
			String inputText = request.getParameter("inputText");
			long time1, time2;

			time1 = System.currentTimeMillis();
			items = Search.search(inputText);
			time2 = System.currentTimeMillis();

			message = "Closely " + (items.size() + " results (" + (double) (time2 - time1) / 1000 + " seconds)");
			error = "OK";

			request.setAttribute("aError", error);
			request.setAttribute("aMessage", message);
			request.setAttribute("aList", items);

		} catch (Exception e) {
			request.setAttribute("aError", error + e.getMessage());
		} finally {
			dispatcher.forward(request, response);
		}
	}

}
