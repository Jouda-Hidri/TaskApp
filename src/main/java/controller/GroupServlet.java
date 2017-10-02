package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Group;

/**
 * Servlet implementation class GroupServlet
 */
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtain a PersistenceManager instance:
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		try {
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			if (title != null && description != null) {
				em.getTransaction().begin();
				em.persist(new Group(title, description));
				em.getTransaction().commit();
			}

			// Display the list of guests:
			List<Group> groupList = em.createQuery("SELECT g FROM Group g", Group.class).getResultList();

			request.setAttribute("groups", groupList);
			request.getRequestDispatcher("/groups.jsp").forward(request, response);

		} finally {
			// Close the PersistenceManager:
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
