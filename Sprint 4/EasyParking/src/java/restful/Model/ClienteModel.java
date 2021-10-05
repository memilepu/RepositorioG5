
package restful.Model;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteModel {
    private String codigo_usu;
    private String correo_usu;
    private String celular_usu;
    private String nombre_usu;
    

    public ClienteModel() {
    }

    public ClienteModel(String codigo_usu, String correo_usu, String celular_usu, String nombre_usu) {
        this.codigo_usu = codigo_usu;
        this.correo_usu = correo_usu;
        this.celular_usu = celular_usu;
        this.nombre_usu = nombre_usu;
        
    }

    public String getcodigo_usu() {
        return codigo_usu;
    }

    public void setcodigo_usu(String codigo_usu) {
        this.codigo_usu = codigo_usu;
    }

    public String getcorreo_usu() {
        return correo_usu;
    }

    public void setcorreo_usu(String correo_usu) {
        this.correo_usu = correo_usu;
    }

    public String getcelular_usu() {
        return celular_usu;
    }

    public void setcelular_usu(String celular_usu) {
        this.celular_usu = celular_usu;
    }

    public String getnombre_usu() {
        return nombre_usu;
    }

    public void setnombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }
        

}
