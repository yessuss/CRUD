
let boton = document.getElementById("btnRegistrar");

boton.addEventListener("click", evento=>{
    registrarPoliza();
})

let registrarPoliza = async()=>{

    let campos = {};

    campos.id = document.getElementById("idPoliza").value;
    campos.idEmpleado = document.getElementById("idEmpleado").value;
    campos.idSKU =  document.getElementById("SKU").value;
    campos.cantidad = document.getElementById("cantidad").value;

    const peticion = await fetch('http://localhost:8080/api/v1/Poliza/Grabar',
    {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(campos)
    });
}


