function cargarDepartamento() {
    var array = ["DISEÑO", "COMERCIAL", "LOGISTICA", "PRODUCCION", "SERVICIO","USUARIOS"];
    array.sort();
    addOptions("departamento", array);
}


//Función para agregar opciones a un <select>.
function addOptions(domElement, array) {
    var selector = document.getElementsByName(domElement)[0];
    for (departamento in array) {
        var opcion = document.createElement("option");
        opcion.text = array[departamento];
        // Añadimos un value a los option para hacer mas facil escoger los pueblos
        opcion.value = array[departamento].toLowerCase()
        selector.add(opcion);
    }
}



function cargarSeccion() {
    var listaPueblos = {
      diseño: ["CALIDAD", "MATERIALES", "PRENDAS", "CATALOGOS", "PRODUCCION_MUESTRAS", "MENSAJERIA"],
      comercial: ["EXPEDIENTE", "MUESTRARIO", "AGENTES", "AMP", "RECEPCION","VENTAS","GERENCIA","MARKETING"],
      logistica: ["VEHICULOS","RUTAS"],
      produccion: ["Cierre de expediente", "Fechas de pedido", "Pedidos de muestra", "Telas faltantes", "Pedidos a vencer","Control de piso","Asignaciones","Carga de producciones","Avances de produccion"],
      servicio: ["EJEMPLO"],
      usuario: ["USUARIOS"]
    }

    var departamento = document.getElementById('departamento')
    var roles = document.getElementById('rol_select')
    var permisos = document.getElementById('permiso')
    var departamentoSeleccionado = departamento.value

    // Se limpian los pueblos
    roles.innerHTML = '<option value="">Seleccione un Pueblo...</option>'
    permisos.innerHTML = '<option value="">Seleccione un Pueblo...</option>'
    
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
    
  }
function cargarPermiso() {
    // Objeto de provincias con pueblos
    var listaPermisos = {
      materiales: material_calidad
    }
    var listaPermisosId = {
    	      
    	      materiales: material_calidad_id
    	    }
    var roles = document.getElementById('rol_select')
    var permisos = document.getElementById('permiso')
    var rolSeleccionado= roles.value
    var rolSeleccionadoId= roles.value
    
    // Se limpian los pueblos
    permisos.innerHTML = '<option value="">Seleccione un Pueblo...</option>'
    
    if(rolSeleccionado !== ''){
      // Se seleccionan los pueblos y se ordenan
    	rolSeleccionado = listaPermisos[rolSeleccionado]
    	rolSeleccionadoId=listaPermisosId[rolSeleccionadoId]


    
      // Insertamos los pueblos
	      rolSeleccionado.forEach(function(permiso,index){
	        let opcion2 = document.createElement('option')
	        opcion2.value = rolSeleccionadoId[index]

	        opcion2.text = permiso
	        permisos.add(opcion2)
      });
    }

  }

function guardar(){
	    var _nom = document.getElementById("departamento").value;
	    var _ape = document.getElementById("rol_select").value;
	    var _id  = document.getElementById("permiso").value;
	    var id_list = document.getElementById("rol_value").value;
	    var _ced = document.getElementById("permiso").options[document.getElementById("permiso").selectedIndex].text;
	    var i = 1;
	    var campo_id;
	    $('#tablita tr').each(function () {
	    	if($(this).find('td').eq(0).html()!=null){
	    		console.log("entra1");
				if(campo_id==null){
					campo_id=$(this).find('td').eq(0).html()
				}
				else{
					campo_id=$(this).find('td').eq(0).html()+","+campo_id;
				}
				
	    		id_list=campo_id;
	    	}
	    });

	    if(id_list!=null){
	    	console.log("entra2 "+id_list);
		    for(var j=0;j<=id_list.split(",").length;j++){

		    	if(_id==id_list.split(",")[j]){
		    		console.log("entra3 "+_id);
		    		return false;
		    	}
		    }
	    }

	    var fila="<tr><td style='display:none;'>"+_id+"</td><td>"+_nom+"</td><td>"+_ape +"</td><td>"+_ced +"</td><td>"+'<button type="button" name="remove" id="' + i + '"onclick="eliminar(this)" class="btn btn-danger btn_remove">Quitar</button></td></tr>';
	    i++;
	    var btn=document.createElement("TR");
	   	btn.innerHTML=fila;
	    document.getElementById("tablita").appendChild(btn);
	    
		$('#tablita tr').each(function () {
			if(campo_id==null){
				campo_id=$(this).find('td').eq(0).html()
			}
			else{
		  campo_id=$(this).find('td').eq(0).html()+","+campo_id;
			}
		  document.getElementById("rol_value").value = campo_id;
		 });
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