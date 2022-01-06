// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});


async function registrarUsuario(){

    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apPaterno = document.getElementById('txtAPaterno').value;
    datos.apMaterno = document.getElementById('txtApMaterno').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.telefono = document.getElementById('txtTelefono').value;
    datos.password = document.getElementById('txtContraseña').value;

    let repetirPassword =  document.getElementById('txtRepetirContraseña').value; //Varible para almacenar la repeticion de contraseña

    if (repetirPassword != datos.password){//Validacion si las contraseñas coinciden
        alert('Las contraseñas no coinciden');
        return;
    }

    const request = await fetch('api/usuarios'{
        // AWAIT ESPERA EL RESULTADO DE LA FUNCION Y LA GUARDA EN REQUEST
        // AL UTILIZAR AWAIT SE TIENE QUE UTILIZAR ASYNC
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)//Convierte objeto js a string json
    });
}