package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Subscription;
import model.Todo;

/**
 * Servlet implementation class TodoServlet
 */
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtain a PersistenceManager instance:
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		String id = request.getParameter("id");
		if (id == null) {
			// Display the list of todos for the user
			List<Todo> todoList = em.createQuery("SELECT d FROM Todo d WHERE userId = 1", Todo.class).getResultList();
			request.setAttribute("todos", todoList);
			// Display the list of the memberships for the user
			List<Subscription> subscriptionList = em.createQuery("SELECT s FROM Subscription s WHERE userId = 1", Subscription.class).getResultList();
			request.setAttribute("subscriptions", subscriptionList);
			// Display the list of the other todos
			List<Todo> otherList = em.createQuery("SELECT d FROM Todo d WHERE userId != 1", Todo.class).getResultList();
			List<Todo> availableList = new ArrayList<Todo>();
			for(Todo other : otherList) {
				for(Subscription subscription: subscriptionList) {
					if(subscription.getGroupId()==other.getGroupId()) {
						availableList.add(other);
					}
				
				}
			}
			
			request.setAttribute("availables", availableList);
			request.getRequestDispatcher("/todos.jsp").forward(request, response);
		} else {

			// Display the todo:
			Todo todo = em.createQuery("SELECT d FROM Todo d WHERE id = " + id, Todo.class).getSingleResult();
			request.setAttribute("todo", todo);
			request.getRequestDispatcher("/todo.jsp").forward(request, response);

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtain a PersistenceManager instance:
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		try {
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			if (title != null && description != null) {
				em.getTransaction().begin();
				em.persist(new Todo(title, description));
				em.getTransaction().commit();
			}

			doGet(request, response);

		} finally {
			// Close the PersistenceManager:
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}

}
