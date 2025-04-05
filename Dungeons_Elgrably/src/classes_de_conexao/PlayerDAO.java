package classes_de_conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
package dao;
import player.Player;
import classes_de_conexao.Conexao;

public class PlayerDAO {

    public void inserir(Player p) {
        String sql = "INSERT INTO players (idPlayer, name, password, balance) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.faz_conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getIdPlayer());
            stmt.setString(2, p.getName());
            stmt.setString(3, p.getPassword());
            stmt.setInt(4, p.getBalance());

            stmt.executeUpdate();
            System.out.println("✅ Player inserido com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("❌ Erro ao inserir player: " + e.getMessage());
        }
    }
}

}
