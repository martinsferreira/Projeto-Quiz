<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@ page import="Quiz.conexao"%>
<%@ page import="Quiz.QuizDAO"%>
<%@ page import="Quiz.QuizBean"%>

<style>
    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100px;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }
</style>

<%
    String nome = request.getParameter("nomehtml");
    String resultado = request.getParameter("resultado");
    
    Connection con = conexao.abriConexao();
    QuizDAO dao = new QuizDAO(con);
    QuizBean qb = new QuizBean();
    qb.setNome(nome);
    qb.setResultado(Integer.parseInt(resultado));
    
    
    
    //Inserir a lista com o ranking aqui
    dao.inserir(qb);
    
    List<QuizBean> lista = dao.listarTodos(qb);
    %>
    <h4>
    <%
        if(lista != null){
    %>
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Resultado</th>
                </tr>
                    <%for(QuizBean tabela : lista){%>
                        <tr>
                            <th><%out.print(tabela.getNome());%></th>
                            <th><%out.print(tabela.getResultado()); %></th>
                        </tr>
                  <%}%>
            </table>                      
        <%}%>
    </h4>