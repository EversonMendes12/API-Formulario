package control;

import factory.ConnectionDB;
import model.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    Connection conn;

    public UserDAO(){
        conn = ConnectionDB.getConnection();
    }

    public void cadastrar(User u) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO usuario (usuario,primeiroNome,segundoNome,passwd,idade,cpf)VALUES(?,?,?,?,?,?)");
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getPrimeiroNome());
            stmt.setString(3, u.getSegundoNome());
            stmt.setString(4, u.getPassword());
            stmt.setString(5, u.getIdade());
            stmt.setInt(6, u.getCpf());

            stmt.executeUpdate();

            System.out.println("Usuário cadastrado");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }

    }

}
