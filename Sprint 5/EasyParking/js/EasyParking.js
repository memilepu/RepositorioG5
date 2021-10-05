const url = "http://localhost:8080/EasyParking/easyparking/usuarios"
const contenedor = document.querySelector('tbody')

let resultados = ''

const modalUsuarios = new bootstrap.Modal(document.getElementById('modalUsuario'))
const formUsuarios = document.querySelector('form')
const CodigoUsuario = document.getElementById('Codigo Usuario')
const CorreoUsuario = document.getElementById('Correo Usuario')
const CelularUsuario = document.getElementById('Celular Usuario')
const NombreUsuario = document.getElementById('Nombre Usuario')

let opcion = ''

btnCrear.addEventListener('click', () => {
    
    CodigoUsuario.value = ''
    CorreoUsuario.value = ''
    CelularUsuario.value = ''
    NombreUsuario.value = ''
    CodigoUsuario.disabled = false
    modalUsuarios.show()
    opcion = 'Registrar'
})

const ajax = (options) => {
    let { url, method, success, error, data } = options;
    const xhr = new XMLHttpRequest();

    xhr.addEventListener("readystatechange", (e) => {
        if (xhr.readyState !== 4) return;

        if (xhr.status >= 200 && xhr.status < 300) {
         console.log("mensaje: ",xhr)
            let json = JSON.parse(xhr.responseText);
            success(json);
        } else {
            let message = xhr.statusText || "Ocurrió un error";
            error(`Error ${xhr.status}: ${message}`);
        }
    });

    xhr.open(method || "GET", url);
    xhr.setRequestHeader("Content-type", "application/json; charset=utf-8");
    xhr.send(JSON.stringify(data));
};

const getAll = () => {
    ajax({
        url: url,
        method: "GET",
        success: (res) => {
            console.log(res);

            res.forEach((usuario) => {
                resultados += `<tr>
                        <td width="15%">${usuario.codigo_usu}</td>
                        <td width="25%">${usuario.correo_usu}</td>
                        <td width="15%">${usuario.celular_usu}</td>
                        <td width="25%">${usuario.nombre_usu}</td>
                        <td class="text-center" width="20%"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                    </tr>`
            });

            contenedor.innerHTML = resultados
        },
        error: (err) => {
            console.log(err);
            $table.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`);
        },
    });
};

document.addEventListener("DOMContentLoaded", getAll);

document.addEventListener("click", (e) => {

    if (e.target.matches(".btnBorrar")) {
        const fila = e.target.parentNode.parentNode
        const CodigoUsuario = fila.firstElementChild.innerHTML
        console.log(CodigoUsuario)
        alertify.confirm(`¿Estás seguro de eliminar el Codigo del Usuario ${CodigoUsuario}?`,
            function () {
                ajax({
                    url: url + "/" + CodigoUsuario,
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    success: (res) => location.reload(),
                    error: (err) => alert(err),
                });
                alertify.success('Registro eliminado')
            },
            function () {
                alertify.error('Cancel')
            });


    }
    if (e.target.matches(".btnEditar")) {
        const fila = e.target.parentNode.parentNode
        CodigoUsuario.value = fila.children[0].innerHTML
        CorreoUsuario.value = fila.children[1].innerHTML
        CelularUsuario.value = fila.children[2].innerHTML
        NombreUsuario.value = fila.children[3].innerHTML
        CodigoUsuario.disabled = true
        opcion = 'editar'
        modalUsuarios.show()
    }
})

formUsuarios.addEventListener('submit', (e) => {
    e.preventDefault()
    let metodo = "POST"
    if (opcion == 'editar') {
        metodo = "PUT"
 
    }
    ajax({
        url: url,
        method: metodo,
        headers: {
            'Content-Type': 'application/json'
        },
        success: (res) => location.reload(),
        error: (err) =>
            $form.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`),
        data: {
            "codigo_usu": CodigoUsuario.value,
            "correo_usu": CorreoUsuario.value,
            "celular_usu": CelularUsuario.value,
            "nombre_usu": NombreUsuario.value
            
        },
    });
    modalUsuarios.hide()
})


