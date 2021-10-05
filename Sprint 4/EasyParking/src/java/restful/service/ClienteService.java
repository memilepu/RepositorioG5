package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.ClienteModel;
import restful.Model.Conexion_MYSQL_;

public class ClienteService {

    public ArrayList<ClienteModel> getUsuarios() {
        ArrayList<ClienteModel> lista = new ArrayList<>();
        Conexion_MYSQL_ conn = new Conexion_MYSQL_();
        String sql = "SELECT * FROM usuario";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setcodigo_usu(rs.getString("codigo_usu"));
                cliente.setcorreo_usu(rs.getString("correo_usu"));
                cliente.setcelular_usu(rs.getString("celular_usu"));
                cliente.setnombre_usu(rs.getString("nombre_usu"));
                
                lista.add(cliente);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    public ClienteModel getUsuario(String codigo_usu) {
        ClienteModel cliente = new ClienteModel();
        Conexion_MYSQL_ conex = new Conexion_MYSQL_();
        String Sql = "SELECT * FROM usuario WHERE codigo_usu = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, codigo_usu);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                cliente.setcodigo_usu(rs.getString("codigo usu"));
                cliente.setcorreo_usu(rs.getString("correo usu"));
                cliente.setcelular_usu(rs.getString("celular usu"));
                cliente.setnombre_usu(rs.getString("nombre usu"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return cliente;
    }

    public ClienteModel addUsuario(ClienteModel cliente) {
        Conexion_MYSQL_ conex = new Conexion_MYSQL_();
        String Sql = "INSERT INTO usuario(codigo_usu,correo_usu,celular_usu,nombre_usu)";
        Sql = Sql + "values (?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, cliente.getcodigo_usu());
            pstm.setString(2, cliente.getcorreo_usu());
            pstm.setString(3, cliente.getcelular_usu());
            pstm.setString(4, cliente.getnombre_usu());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return cliente;
    }

    public ClienteModel updateUsuario(ClienteModel cliente) {
        Conexion_MYSQL_ conex = new Conexion_MYSQL_();
        String Sql = "UPDATE usuario SET correo_usu=?,celular_usu=?,nombre_usu=? WHERE codigo_usu=?";
        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(4, cliente.getcodigo_usu());
            pstm.setString(1, cliente.getcorreo_usu());
            pstm.setString(2, cliente.getcelular_usu());
            pstm.setString(3, cliente.getnombre_usu());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al actualizar los datos  " + excepcion.getMessage());
            return null;
        }
        return cliente;
    }

    public String delUsuario(String codigo_usu) {
        Conexion_MYSQL_ conn = new Conexion_MYSQL_();

        String sql = "DELETE FROM usuario WHERE codigo_usu= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, codigo_usu);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Registro Borrado con exito\"}";
    }
}
