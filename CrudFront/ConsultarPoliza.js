window.onload = function(){
    listarPolizas();
}

let listarPolizas = async()=>{
    const peticion = await fetch('http://localhost:8080/api/v1/Poliza/ConsultarT/0',
    {
        method: "GET",
        headers:{
            "Accept": "application/json",
            "Content-Tyep": "application/json"
        }
    });

    const polizas = await peticion.json();

    let contenidoTabla = "";

    for (let i in polizas) {
        for (let j in polizas[i]) {
            for (let k in polizas[i][j]){
          
                //console.log(polizas[i][j][k].idPoliza,polizas[i][j][k].cantidad,polizas[i][j][k].empleadogenero,polizas[i][j][k].idSKU);
                let contenidoFila = `<tr>
                <td>${polizas[i][j][k].idPoliza}</td>
                <td>${polizas[i][j][k].empleadogenero}</td>
                <td>${polizas[i][j][k].idSKU}</td>
                <td>${polizas[i][j][k].nombreProducto}</td>
                <td>${polizas[i][j][k].cantidad}</td>
                <td>
                <i onClick="editarPolizas(${polizas[i][j][k].idPoliza})" class="material-icons button edit">edit</i>
                <i onClick="borrarPolizas(${polizas[i][j][k].idPoliza})"class="material-icons button delete">delete</i>
                </td>
                </tr>`

                contenidoTabla += contenidoFila;

            }
          
        }
    }

    document.querySelector("#tabla tbody").outerHTML = contenidoTabla;
}

let borrarPolizas = async(id)=>{

    let campos = {};

    campos.id = id;
    

    const peticion = await fetch('http://localhost:8080/api/v1/Poliza/Eliminar',
    {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(campos)
    });

    document.getElementById("idPoliza").value="";
    document.getElementById("idEmpleado").value="";
    document.getElementById("SKU").value="";
    document.getElementById("cantidad").value="";

    listarPolizas();
}

let ieditar;

let editarPolizas = async(id)=>{
    
    mostrarFormulario();


    ieditar = id;

    
    const peticion = await fetch('http://localhost:8080/api/v1/Poliza/ConsultarT/'+ieditar,
    {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        
    });
    
    const polizas = await peticion.json();

    document.getElementById("idPoliza").value=polizas.data.listPoliza[0].idPoliza;
    document.getElementById("idEmpleado").value=polizas.data.listPoliza[0].idempleadogenero;
    document.getElementById("SKU").value=polizas.data.listPoliza[0].idSKU;
    document.getElementById("cantidad").value=polizas.data.listPoliza[0].cantidad;

    let btnActualizar = document.getElementById("btnActualizar");
}

btnActualizar.addEventListener("click", evento=>{
    aplicarActualizacion(ieditar);
})

btnCancelar.addEventListener("click", evento=>{
    document.getElementById("formulario").style.visibility="hidden";
})

let aplicarActualizacion = async(id)=>{

    let campos = {};

    campos.id = id;
    campos.idEmpleado = document.getElementById("idEmpleado").value;
    campos.idSKU =  document.getElementById("SKU").value;
    campos.cantidad = document.getElementById("cantidad").value;

    const peticion = await fetch("http://localhost:8080/api/v1/Poliza/Actualizar",
    {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(campos)
    });

    listarPolizas();
}

function mostrarFormulario(){
    
    document.getElementById("formulario").style.visibility="visible";
}