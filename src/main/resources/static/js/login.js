// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});


async function iniciarSesion(){

    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtContraseña').value;

    const request = await fetch('api/login',{
        // AWAIT ESPERA EL RESULTADO DE LA FUNCION Y LA GUARDA EN REQUEST
        // AL UTILIZAR AWAIT SE TIENE QUE UTILIZAR ASYNC
        method: 'POST',
            headers: {
            'Accept': 'application/json',
                'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)//Convierte objeto js a string json
    });
    const respuesta = await request.text(); //CONVIERTE LA REQUEST A JSON Y LA ASIGNA A respuesta

    if (respuesta == 'OK'){
        window.location.href = 'usuarios.html'
    }else {
        alert("Las credenciales son incorrectas");
    }

}