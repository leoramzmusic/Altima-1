//Ajax para traer los departamentos
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


//Función para agregar departamentos a un <select>.
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


//Función para llenar las secciones de acuerdo al departamento
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
		        opcion.value = rol
		        opcion.text = rol
		        roles.add(opcion)
		      });
		    }
		},
		error: (e) => {
		}
	});
  }

//Función para cargar los permisos dentro de la tabla
function cargarPermiso(departamento,rol_select) {
console.log(departamento, rol_select);

	$.ajax({
		method: "GET",
		url: "/listPermisos",
		data:{
			departamento: departamento,
			seccion: rol_select
		},
		success: (data) => {
			var opciones="";
			for(i in data){
				opciones+= "<option value='"+data[i][0]+"'>"+data[i][1]+"</option>";
			}
			
			permiso = opciones;
		}
	});

  }

//Función para agregar un rol a la tabla
function guardarRol(){
	var filas = $("#tablita").find('tr');
	
	var resultD = $('#departamento').val();
	var resultS = $('#rol_select').val();
	var validador = true;
	
	if(resultD=="" || resultS==""){
		validador = false;
		Swal.fire({
			icon: 'error',
			title: 'Error',
			text: '¡Debe agregar un campo válido!',
			showConfirmButton: false,
	        timer: 3500
		  })
	}
	
	else{
		for(i=0; i<filas.length; i++){
			var celdas = $(filas[i]).find("td");
			if($(celdas[0]).text()==resultD && $(celdas[1]).text()==resultS){
				validador = false;
				Swal.fire({
					icon: 'error',
					title: 'Error',
					text: 'Ya se agregó esa muestra',
					showConfirmButton: false,
			        timer: 3500
				  })
			}
		}
	}
	
	//si cumple las validaciones de llenado, se agrega el rol a la tabla
	if(validador==true){
	    var _nom = document.getElementById("departamento").value;
	    if(_nom=="Servicioalcliente"){_nom="Servicio al cliente";}
	    var _ape = document.getElementById("rol_select").value;
	    var fila="<tr><td>"+_nom+"</td><td>"+_ape +"</td><td><select multiple class='form-control selectpicker'>"+permiso+"</select></td><td>"+'<button type="button" name="remove" class="btn btn-danger btn_remove borrar">Eliminar</button></td></tr>';

	    $("#tablita").append(fila);
	    $('.selectpicker').selectpicker(["refresh"]);
	}
	
}

//   Borrar registro de la tabla de agregar un rol    //
//                                                    //
$(document).on('click', '.borrar', function (event) { //
event.preventDefault();                               //
$(this).closest('tr').remove();                       //
});                                                   //
//====================================================//

 // Iniciar la carga de provincias solo para comprobar que funciona
cargarDepartamento();


//Función para guardar el usuario con todos sus roles
function guardarUsuario(){
	var filas = $("#tablita").find('tr');
	
	var empleado = $('#empleado').val();
	var nombreUsuario = $('#username').val();
	var password = $('#pass').val();
	var confirmPass = $('#confirmPass').val();
	var statusUser = $('#statusUser').val();
	var userid = $('#idUser').val();
	var datosJson = [];
	var permisos=[];
	var i;
	var validador = true;
	
// Condicion para validar que no existe un usuario
	if($('#idUser').val()==""){                 //
		
		for(i in userValid){
			
			if(nombreUsuario==userValid[i][1] || nombreUsuario.toLowerCase()=="admin"){
				Swal.fire({
					icon: 'error',
					title: 'Error',
					text: '¡Ya existe ese nombre de usuario, elija otro!',
					showConfirmButton: false,
			        timer: 3500
				  })
				validador = false;
			}
		}
		
		
		if(filas.length==0 || empleado=="" || nombreUsuario=="" || statusUser=="" || password=="" || confirmPass==""){
		console.log(filas);
		Swal.fire({
			icon: 'error',
			title: 'Error',
			text: '¡Todos los campos deben de estar llenos!',
			showConfirmButton: false,
	        timer: 3500
		  })
		validador = false;
		}
		
			if(password!=confirmPass){
				validador = false;
				Swal.fire({
					icon: 'error',
					title: 'Error',
					text: '¡Las contraseñas deben coincidir!',
					showConfirmButton: false,
			        timer: 3500
				  })
			}
		
		else{
			for(i=0; i<filas.length; i++){
				var celdas = $(filas[i]).find("td");
				if($($(celdas[2]).find("select")).val()==""){
					validador = false;
					Swal.fire({
						icon: 'error',
						title: 'Error',
						text: '¡Debe haber al menos un permiso!',
						showConfirmButton: false,
				        timer: 3500
					  })
				}
			}
		}
// Si las validaciones son correctas, manda los JSON al controller mediante Ajax			
		if (validador==true){
			for(i=0; i<filas.length; i++){
				var celdas = $(filas[i]).find("td");
				var record = {departamento:  $(celdas[0]).text(), 
							  seccion: 		 $(celdas[1]).text()};
				permisos.push($($(celdas[2]).find("select")).val());
				datosJson.push(record);
				Swal.fire({
					icon: 'success',
					title: 'Correcto',
					text: '¡Se han insertado los datos!',
					showConfirmButton: false,
			        timer: 5000
				  })
			}

			$.ajax({
		    	method: "POST",
				url: "/guardarUser",
				data:{
					"_csrf": $('#token').val(),
					Empleado: empleado,
					NombreUser: nombreUsuario,
					Password: password,
					ConfirmPass: confirmPass,
					StatusUser: statusUser,
					"DatosJson": JSON.stringify(datosJson),
					"Permisos": JSON.stringify(permisos),
					idUser: userid
				},
				success: (data) => {
					
					location.href ="/administracion_usuarios";
				},
				error: (e) => {
				}	
			});
		}
	}
	
// Condicion para validar que ya existe un usuario
	else{
		var userCurrentName = $('#userCurrentName').val();
		if(nombreUsuario!=userCurrentName){	
			for(i in userValid){
				if(nombreUsuario==userValid[i][1] || nombreUsuario.toLowerCase()=="admin"){
					Swal.fire({
						icon: 'error',
						title: 'Error',
						text: '¡Ya existe ese nombre de usuario, elija otro!',
						showConfirmButton: false,
				        timer: 3500
					  })
					validador = false;
				}
			}
		}
		
		if(filas.length==0 || empleado=="" || nombreUsuario=="" || statusUser==""){
			console.log(filas);
			Swal.fire({
				icon: 'error',
				title: 'Error',
				text: '¡Todos los campos deben de estar llenos!',
				showConfirmButton: false,
		        timer: 3500
			  })
			validador = false;
			}
			

			
			else{
				for(i=0; i<filas.length; i++){
					var celdas = $(filas[i]).find("td");
					if($($(celdas[2]).find("select")).val()==""){
						validador = false;
						Swal.fire({
							icon: 'error',
							title: 'Error',
							text: '¡Debe haber al menos un permiso!',
							showConfirmButton: false,
					        timer: 3500
						  })
					}
				}
			}
		
		
		if (validador==true){
			for(i=0; i<filas.length; i++){
				var celdas = $(filas[i]).find("td");
				var record = {departamento:  $(celdas[0]).text(), 
							  seccion: 		 $(celdas[1]).text()};
				permisos.push($($(celdas[2]).find("select")).val());
				datosJson.push(record);
				Swal.fire({
					icon: 'success',
					title: 'Correcto',
					text: '¡Se han insertado los datos!',
					showConfirmButton: false,
			        timer: 5000
				  })
			}
			$.ajax({
		    	method: "POST",
				url: "/guardarUser",
				data:{
					"_csrf": $('#token').val(),
					Empleado: empleado,
					NombreUser: nombreUsuario,
					Password: password,
					ConfirmPass: confirmPass,
					StatusUser: statusUser,
					"DatosJson": JSON.stringify(datosJson),
					"Permisos": JSON.stringify(permisos),
					idUser: userid
				},
				success: (data) => {
					
					location.href ="/administracion_usuarios";
				},
				error: (e) => {
				}	
			});
		}
	}
}


// Función para cargar los select de los permisos actuales de acuerdo a su rol
function mapearPermisos(){
	console.log("Si esta entrando");
	var filas = $("#tablita").find('tr');
	for(u=0; u<filas.length; u++){
		var celdas = $(filas[u]).find("td");
		var data = roles;
		
		for (i in data){
			if($(celdas[1]).text()==data[i][1]){
			$(celdas[2]).find("select").append("<option value="+ data[i][0] +">"+ data[i][2] +"</option>");
			}
			
		}
	}

	checkSelect();
	
}

//Función para marcar como seleccionados los permisos que tiene activos
function checkSelect(){
	var filas = $("#tablita").find('tr');
	for(i=0; i<filas.length; i++){
		var celdas = $(filas[i]).find("td");
		var data = permisos;
		for (u in data){
			if($(celdas[1]).text()==data[u][1]){
				console.log($(celdas[1]).text());
				console.log(data[u][0]);
				$($(celdas[2]).find("option[value="+data[u][0]+"]")).attr("selected", true);
				
			}
		}
	}	
		console.log("si se mapea");
} 

