package Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO {

    private Connection con;

    public QuizDAO(Connection con) {
        setCon(con);
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String inserir(QuizBean dadosBean) {
        String sql = "insert into ranking(resultado,nome)values(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, dadosBean.getResultado());
            ps.setString(2, dadosBean.getNome());
            if (ps.executeUpdate() > 0) {
                return "Cadastrado com sucesso";
            } else {
                return "Falha ao inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<QuizBean> listarTodos(QuizBean qb) {
        String sql = "select * from ranking order by resultado desc";
        List<QuizBean> listaRanking = new ArrayList<QuizBean>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    QuizBean qb2 = new QuizBean();
                    qb2.setResultado(rs.getInt(1));
                    qb2.setNome(rs.getString(2));
                    listaRanking.add(qb2);
                }
                return listaRanking;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
}
