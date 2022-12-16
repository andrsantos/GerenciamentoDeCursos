package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.netbiis.Cliente;
import com.netbiis.Cursos;
import com.netbiis.Pagamento;
import com.netbiis.PagamentoId;

/**
 * Servlet implementation class ServletControlador
 */
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAApp");
	EntityManager em = emf.createEntityManager();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int cpf2;
		int idformulario;// 1-cliente//2- cursos//3-pagamentos
		int tipoformulario;//1.1 - consultar...
		String nome, email,cpf, nomecurso,url,datainscricao;
		int cdcurso;
		int valorcurso;
		idformulario = Integer.parseInt(request.getParameter("idformulario"));
		tipoformulario = Integer.parseInt(request.getParameter("tipoformulario"));
		EntityTransaction tx = em.getTransaction();
		HttpSession session = request.getSession();
		if(idformulario==1) {//Clientes
			
			switch(tipoformulario) {
			case 11: // Consultar Todos
			{
			
				TypedQuery<Cliente> query = em.createQuery(""+"Select c from cliente c", Cliente.class);
		        List<Cliente>clientes = query.getResultList();
				session.setAttribute("mensagem", "Total de clientes é: " + clientes.size());
				session.setAttribute("clientes", clientes);
				response.sendRedirect("clientes/consultaTodos.jsp");
				break;
			}
			case 12: 
			{
			
			    cpf = request.getParameter("cpf");
				cpf = cpf.replaceAll("[.-]","");
				
				
				Cliente cliente = em.find(Cliente.class,cpf);
				
				if(cliente != null) {//cliente encontrado
					session.setAttribute("mensagem", "Cliente "+cpf+"encontrado!");
					session.setAttribute("cliente", cliente);
				}
				else {//cliente n existe
					session.setAttribute("mensagem", "Cliente "+cpf+"não encontrado!");
					session.setAttribute("cliente", null);
				}
				response.sendRedirect("clientes/resultado.jsp");
				System.out.println(cliente);
				break;
			}
			
			case 13://Cadastrar
			{
				
				
			    cpf = request.getParameter("cpf");
				cpf = cpf.replaceAll("[.-]","");
				nome = request.getParameter("nome");
				email = request.getParameter("email");
				Cliente cliente = new Cliente(cpf,nome,email);
				tx.begin();
				em.persist(cliente);
				tx.commit();
				session.setAttribute("mensagem","Cliente "+cpf+"Cadastrado!");
				session.setAttribute("cliente", cliente);
				response.sendRedirect("clientes/resultado.jsp");
				/*Cliente cliente = new Cliente(cpf,nome,email);
				em.persist(cliente);*/
				break;
			}
		    
			case 14://Alterar
			{
				cpf = request.getParameter("cpf");
				cpf = cpf.replaceAll("[.-]","");
				nome = request.getParameter("nome");
				email = request.getParameter("email");
				Cliente cliente = em.find(Cliente.class,cpf);
				if(cliente != null) {
					session.setAttribute("mensagem", "Cliente "+cpf+"Encontrado!");
					session.setAttribute("cliente", cliente);
					Cliente cliente2 = new Cliente(cpf,nome,email);
					tx.begin();
					em.merge(cliente2);
					tx.commit();
				} else {
					session.setAttribute("mensagem","Cliente não encontrado!");
					session.setAttribute("cliente", null);
				}
				tx.begin();
				em.merge(cliente);
				tx.commit();
				response.sendRedirect("clientes/resultado.jsp");
				break;	
			}
			
			
			case 15://Excluir
			{
				
			    cpf = request.getParameter("cpf");
				cpf = cpf.replaceAll("[.-]","");			
				Cliente cliente = em.find(Cliente.class,cpf);
				
				if(cliente != null) {//cliente encontrado
					session.setAttribute("mensagem", "Cliente "+cpf+"encontrado!");
					tx.begin();
					em.remove(cliente);
					tx.commit();
					session.setAttribute("mensagem", "Cliente"+cpf+"Excluído!");
				}
				else {//cliente n existe
					session.setAttribute("mensagem", "Cliente "+cpf+"não encontrado! Exclusão cancelada");
					session.setAttribute("cliente", null);
				}
				response.sendRedirect("clientes/resultado.jsp");
				System.out.println(cliente);
				break;
			}
			}
			
			
		} else if (idformulario==2) {//Cursos
			switch(tipoformulario) {
			case 21: // Consultar Todos
			//{
				TypedQuery<Cursos> query = em.createQuery(""+"Select c from cursos c", Cursos.class);
		        List<Cursos>cursos = query.getResultList();
				session.setAttribute("mensagem", "Total de cursos é: " + cursos.size());
				session.setAttribute("cursos", cursos);
				response.sendRedirect("cursos/consultaTodos.jsp");
				break;
		//	}
			case 22: 
			{
				cdcurso = Integer.parseInt(request.getParameter("curso"));
				Cursos curso = em.find(Cursos.class, cdcurso);
				if(curso != null) {
					session.setAttribute("mensagem", "Curso"+cdcurso+"Encontrado!");
					session.setAttribute("cliente", null);
				} else {
					session.setAttribute("mensagem", "Curso não existe");
					response.sendRedirect("cursos/resultado,jsp");
					
				}
				/*Cliente cliente = em.find(Cliente.class,cpf);
				System.out.println(cliente);*/
				break;
			}
			
			case 23://Cadastrar
			{
				
				cdcurso = Integer.parseInt(request.getParameter("curso"));
			    nomecurso = request.getParameter("nome");
			    valorcurso = Integer.parseInt(request.getParameter("valor"));
			    url = request.getParameter("site");
				Cursos curso = new Cursos(cdcurso,nomecurso,valorcurso,url);
				tx.begin();
				em.persist(curso);
				tx.commit();
				session.setAttribute("mensagem", "Curso cadastrado com sucesso!");
				response.sendRedirect("cursos/resultado.jsp");
				
				/*Cliente cliente = new Cliente(cpf,nome,email);
				em.persist(cliente);*/
				break;
			}
		    
			case 24://Alterar
			{

				cdcurso = Integer.parseInt(request.getParameter("curso"));
			    nomecurso = request.getParameter("nome");
			    valorcurso = Integer.parseInt(request.getParameter("valor"));
			    url = request.getParameter("site");
				Cursos curso = em.find(Cursos.class, cdcurso);
				if(curso != null) {
			    curso = new Cursos(cdcurso,nomecurso,valorcurso,url);
				tx.begin();
				em.merge(curso);
				tx.commit();
				session.setAttribute("mensagem", "Curso alterado com sucesso!");
				} else {
					session.setAttribute("mensagem", "O curso não existe!");
				}
				response.sendRedirect("cursos/resultado.jsp");
				break;	
			}
			
			
			case 25://Excluir
			{
				cdcurso = Integer.parseInt(request.getParameter("curso"));
				Cursos curso = em.find(Cursos.class, cdcurso);
				if(curso != null) {
					session.setAttribute("mensagem", "Curso"+cdcurso+"Encontrado!");
					tx.begin();
					em.remove(curso);
					tx.commit();
					session.setAttribute("cliente", null);
				} else {
					session.setAttribute("mensagem", "Curso não existe");
					response.sendRedirect("cursos/resultado,jsp");
					
				}
				break;
			}
			
		}
		}
           else if (idformulario==3) {//Pagamentos
        	   switch(tipoformulario) {
   			case 31: // Consultar Todos
   			{
        	   TypedQuery<Pagamento> query = em.createQuery(""+"Select c from pagamentos c", Pagamento.class);
		        List<Pagamento> pagamentos = query.getResultList();
				session.setAttribute("mensagem", "Total de pagamentos é: " + pagamentos.size());
				session.setAttribute("pagamentos", pagamentos);
				response.sendRedirect("pagaentos/consultaTodos.jsp");
				break;
   			}
   			case 32: 
   			{   
   				cpf = request.getParameter("cpf");
   				cpf = cpf.replaceAll("[.-]", "");
   				cpf2 = Integer.parseInt(cpf);
   				cdcurso = Integer.parseInt(request.getParameter("curso"));
   				
   				PagamentoId pgtoid = new PagamentoId(cpf2,cdcurso);
   				Pagamento pagamento = em.find(Pagamento.class, pgtoid);
   				
   				if(pagamento != null) {
   					session.setAttribute("mensagem", "Pagamento não encontrado!");
   					session.setAttribute("pagamento", pagamento);
   				} else {
   					session.setAttribute("mensagem", "pagamento não encontrado");
   					session.setAttribute("pagamento", null);
   				}
   				
   				/*Cliente cliente = em.find(Cliente.class,cpf);
   				System.out.println(cliente);*/
   				break;
   			}
   			
   			case 33://Cadastrar
   			{
   				
   				
   				cpf2 = Integer.parseInt(request.getParameter("cpf"));	
   				cdcurso = Integer.parseInt(request.getParameter("curso"));
   				datainscricao = request.getParameter("data");
   				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   				LocalDate date = LocalDate.parse(datainscricao,formatter);
   				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   				
   				PagamentoId pgtoid = new PagamentoId(cpf2, cdcurso);
   				Pagamento pagamento = new Pagamento(pgtoid,fmt.format(date));
   				tx.begin();
   				em.persist(pagamento);
   				tx.commit();
   				session.setAttribute("mensagem", "Pagamento cadastrado!");
   				session.setAttribute("Pagamento", pagamento);
   				response.sendRedirect("pagamentos/resultado.jsp");
   				/*Cliente cliente = new Cliente(cpf,nome,email);
   				em.persist(cliente);*/
   				break;
   			}
   		    
   			case 34://Alterar
   			{
   				cpf2 = Integer.parseInt(request.getParameter("cpf"));	
   				cdcurso = Integer.parseInt(request.getParameter("curso"));
   				datainscricao = request.getParameter("data");
   				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   				LocalDate date = LocalDate.parse(datainscricao,formatter);
   				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   				
   				PagamentoId pgtoid = new PagamentoId(cpf2, cdcurso);
   				Pagamento pagamento = em.find(Pagamento.class, pgtoid);
   				if(pagamento != null) {
   			    pagamento = new Pagamento(pgtoid,fmt.format(date));
   				tx.begin();
   				em.merge(pagamento);
   				tx.commit();
   				session.setAttribute("mensagem", "Pagamento cadastrado!");
   				session.setAttribute("Pagamento", pagamento);
   				} else {
   			    session.setAttribute("mensagem", "Pagamento não encontrado!");
   				}
   				response.sendRedirect("pagamentos/resultado.jsp");
   				break;	
   			}
   			
   			
   			case 35://Excluir
   			{
   				cpf = request.getParameter("cpf");
   				cpf = cpf.replaceAll("[.-]", "");
   				cpf2 = Integer.parseInt(cpf);
   				cdcurso = Integer.parseInt(request.getParameter("curso"));
   				
   				PagamentoId pgtoid = new PagamentoId(cpf2,cdcurso);
   				Pagamento pagamento = em.find(Pagamento.class, pgtoid);
   				
   				if(pagamento != null) {
   					session.setAttribute("mensagem", "Pagamento não encontrado!");
   					session.setAttribute("pagamento", pagamento);
   					tx.begin();
   					em.remove(pagamento);
   					tx.commit();
   				} else {
   					session.setAttribute("mensagem", "pagamento não encontrado");
   					session.setAttribute("pagamento", null);
   				
   				}
   				response.sendRedirect("pagamentos/resultado.jsp");
   				break;
   			}
           }
			
		}
	

}
}
