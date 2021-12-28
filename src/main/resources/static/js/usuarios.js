// Call the dataTables jQuery plugin
$(document).ready(function() {

  cargarUsuarios();

  $('#usuarios').DataTable();
});


async function cargarUsuarios(){

    const request = await fetch('api/usuarios', {
      // AWAIT ESPERA EL RESULTADO DE LA FUNCION Y LA GUARDA EN REQUEST
      // AL UTILIZAR AWAIT SE TIENE QUE UTILIZAR ASYNC
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
    const usuarios = await request.json(); //CONVIERTE LA REQUEST A JSON Y LA ASIGNA A usuarios

    console.log(usuarios);


    let listadoHtml = '';//VARIABLE PARA ALMACENAR LA LISTA DE USUARIOS

    for (let usuario of usuarios){//CICLO PARA LISTAR LOS USUARIOS

        let usuarioHtml = '<tr><td>'
            +usuario.id+'</td><td>'
            +usuario.nombre+'</td><td>'
            +usuario.apPaterno+'</td><td>'
            +usuario.apMaterno+'</td><td>'
            +usuario.email+'</td><td>'
            +usuario.telefono+'</td><td><a href="#" class="btn btn-danger btclassNamecle btn-sm"><i class="fas fa-trash"></iclassName </a></td></tr>';

        listadoHtml += usuarioHtml; //ALMACENAMOS CADA UNO DE LOS USUARIOS EN LA VARIABLE LISTADOHTML
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}
