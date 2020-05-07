function cargarDepartamento() {
    var array = [];
    $.ajax({
    	method: "GET",
		url: "/listRoles",
		success: (data) => {
			var arreglo = [];
			for (i in data){
				arreglo.push(data[i]);
			}
			array = arreglo;

		    addOptions("departamento", array);
		},
		error: (e) => {
		}
	}); 
}


//Función para agregar opciones a un <select>.
function addOptions(domElement, array) {
    var selector = document.getElementsByName(domElement)[0];
    for (departamento in array) {
        var opcion = document.createElement("option");
        opcion.text = array[departamento];
        // Añadimos un value a los option para hacer mas facil escoger los pueblos
        opcion.value = array[departamento].replace(/ /g, "");
        selector.add(opcion);
    }
}



function cargarSeccion() {
	
	$.ajax({
		method: "GET",
		url: "/listSecciones",
		success: (data) => {
			var disenio = [];
			var comercial = [];
			var logistica = [];
			var producción = [];
			var servicioalcliente = [];
			var usuario = [];
			for(i in data){
				if (data[i][0]=="Diseño"){
					disenio.push(data[i][1]);
				}
				if (data[i][0]=="Comercial"){
					comercial.push(data[i][1]);
				}
				if (data[i][0]=="Logística"){
					logistica.push(data[i][1]);
				}
				if (data[i][0]=="Producción"){
					producción.push(data[i][1]);
				}
				if (data[i][0]=="Servicio al cliente"){
					servicioalcliente.push(data[i][1]);
				}
				if (data[i][0]=="Usuarios"){
					usuario.push(data[i][1]);
				}
			}
	
		    var listaPueblos = {
		      Diseño: disenio,
		      Comercial: comercial,
		      Logística: logistica,
		      Producción: producción,
		      Servicioalcliente: servicioalcliente,
		      Usuarios: usuario
		    }
		
		    var departamento = document.getElementById('departamento')
		    var roles = document.getElementById('rol_select')
		    var departamentoSeleccionado = departamento.value
		
		    // Se limpian las secciones
		    roles.innerHTML = '<option value="">Seleccione una Sección...</option>'
		    
		    if(departamentoSeleccionado !== ''){
		      // Se seleccionan los pueblos y se ordenan
		    	departamentoSeleccionado = listaPueblos[departamentoSeleccionado]
		    	departamentoSeleccionado.sort()
		    
		      // Insertamos los pueblos
		      departamentoSeleccionado.forEach(function(rol){
		        let opcion = document.createElement('option')
		        opcion.value = rol.toLowerCase()
		        opcion.text = rol
		        roles.add(opcion)
		      });
		    }
		},
		error: (e) => {
		}
	});
  }


function cargarPermiso() {
	
	$.ajax({
		method: "GET",
		url: "/listPermisos",
		success: (data) => {
			var opciones="";
			for(i in data){
				opciones+= "<option value='"+data[i]+"'>"+data[i]+"</option>";
			}
			
			permisos = opciones;
			console.log(permisos);
		},
		error: (e) => {
		}
		
	});
  }

function guardarRol(){
	
	    var _nom = document.getElementById("departamento").value;
	    var _ape = document.getElementById("rol_select").value;
	    var i = 1;

	    var fila="<tr><td>"+_nom+"</td><td>"+_ape +"</td><td><select multiple class='form-control'>"+permisos+"</select></td><td>"+'<button type="button" name="remove" id="' + i + '"onclick="eliminar(this)" class="btn btn-danger btn_remove">Quitar</button></td></tr>';
	    var btn=document.createElement("TR");
	   	btn.innerHTML=fila;
	    document.getElementById("tablita").appendChild(btn);

	}



function eliminar(t) {
  var campo_id;
  var state=false;
  var td = t.parentNode;
  var tr = td.parentNode;
  var table = tr.parentNode;
  table.removeChild(tr);
	$('#tablita tr').each(function () {
		console.log("este si "+document.getElementById("rol_value").value);
	  campo_id=$(this).find('td').eq(0).html()+","+campo_id;
	  document.getElementById("rol_value").value = campo_id;
	  state=true;
	 });
	if(state==false){
		document.getElementById("rol_value").value=null;
	}
}


 // Iniciar la carga de provincias solo para comprobar que funciona
cargarDepartamento();