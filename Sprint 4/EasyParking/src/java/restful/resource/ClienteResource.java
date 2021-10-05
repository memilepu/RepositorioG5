/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.resource;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import restful.Model.ClienteModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import restful.service.ClienteService;

/**
 *
 * @author SENA
 */
@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    ClienteService usuario = new ClienteService();

    @GET
    public ArrayList<ClienteModel> getUsuarios() {

        ClienteService service = new ClienteService();

        return service.getUsuarios();
    }

    @Path("/{cod_usuario}")
    @GET
    public ClienteModel getUsuario(@PathParam("usuario") String codigo_usu) {

        return usuario.getUsuario(codigo_usu);
    }

    @POST
    public ClienteModel addUsuario(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ClienteModel cliente = gson.fromJson(JSON, ClienteModel.class);
        return usuario.addUsuario(cliente);
    }

    @DELETE
    @Path("/{cod_usuario}")
    public String delUsuario(@PathParam("cod_usuario") String codigo_usu) {

        return usuario.delUsuario(codigo_usu);

    }

    @PUT
    public ClienteModel updateUsuario(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ClienteModel cliente = gson.fromJson(JSON, ClienteModel.class);
        return usuario.updateUsuario(cliente);
    }

}
