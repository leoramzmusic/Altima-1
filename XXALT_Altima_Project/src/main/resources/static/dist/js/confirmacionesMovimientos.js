function listarEmpresas(){
	
	$.ajax({
		 method: "GET",
		    url: "/listarEmpresasMovimiento",
		    data: {

		    },
		    success: (data) => {
		    	console.log(data);
				for (i in data){
					if(data[i].apellidoPaterno==null || data[i].apellidoMaterno==null){
						$('#empresaMovi').append("<option value='"+data[i].idCliente+"'>"+ data[i].nombre + "</option>");
					}
					else{
						$('#empresaMovi').append("<option value='"+data[i].idCliente+"'>"+ data[i].nombre + " " + data[i].apellidoPaterno + " " + data[i].apellidoMaterno +"</option>");
					}
				}
		    },
		    error: (e) => {
		        // location.reload();
		    }
		});
}

function listarMuestras(){
	$.ajax({
		method: "GET",
		url: "/listarMuestras",
		success: (data) => {
			console.log(data);
			for (i in data){
				$('#prendaMovi').append("<option value='"+data[i][3]+"'>"+ 
														  data[i][0].substring(0,3).toUpperCase()  + 
														  data[i][1].substring(0,3).toUpperCase()  + 
														  data[i][2].substring(0,3).toUpperCase()  + 
														  ("00" + data[i][3]).slice(-3) +
														  " " +
														  data[i][0] + "</option>");
			}
		},
		error: (e) => {
		}
	});
} 

function agregarMiniTabla(tablaMuestra){
	//$('#BotonAgregarMuestra').prop('disabled', true);
	result = $('#prendaMovi').val();
	var validador = 0;
	var table = document.getElementById(tablaMuestra);
	
	if(result=="error"){
		Swal.fire({
			icon: 'error',
			title: 'Error',
			text: 'Debe agregar un campo válido!',
			showConfirmButton: false,
	        timer: 3500
		  })
	}
	
	else{
		
		foreach(table, 'tr:not(:first-child)', function(row) {
			
			if ($('#idMuestras').val()==result){
				validador=1;
				Swal.fire({
					icon: 'error',
					title: 'Error',
					text: 'Ya se agregó esa muestra',
					showConfirmButton: false,
			        timer: 3500
				  })
			}
			});
		
		if(validador==0){
			$.ajax({
				
				method: "GET",
				url: "/agregarMuestraTablita",
				data: {idMuestra: result},
				success: (data) => {
					console.log(data);
					var ceros = "00";
					$('#tablaMuestra').append("<tr>" +
		                                    "<td id='codigoBarras'>" +data[0].substring(0,3).toUpperCase()  + 
													data[1].substring(0,3).toUpperCase()  + 
													data[2].substring(0,3).toUpperCase()  + 
													(ceros + data[3]).slice(-3)+"</td>" +
		                                    "<td id='nombreMuestra'>" + data[0] + "</td>" +
		                                    "<td class='tdcenter'>" +
		                                    	"<input type='hidden' id='idMuestras' value='"+data[3]+"'>" +
		                                        "<a class='btn btn-danger btn-circle btn-sm text-white popoverxd' id='borrar' data-container='body' data-placement='top' data-content='Remover'><i class='fas fa-minus'></i></a>" +
		                                    "</td>" +
		                                "</tr>");
					console.log($('#codigoBarras').text());
				},
				error: (e) => {
				}
				
			});
		}
	}
}

//  Borrar registro de la tabla de agregar una muestra  //
//                                                      //
  $(document).on('click', '#borrar', function (event) { //
      event.preventDefault();                           //
      $(this).closest('tr').remove();                   //
      $('#BotonAgregarMuestra').prop('disabled', false);//
  });                                                   //
//======================================================//

  
  function foreach(root, selector, callback) {
	   if (typeof selector == 'string') {
	      var all = root.querySelectorAll(selector);
	      for (var each = 0; each < all.length; each++) {
	         callback(all[each]);
	      }
	   } else {
	      for (var each = 0; each < selector.length; each++) {
	         foreach(root, selector[each], callback);
	      }
	   }
	}
  
	function guardarNuevoMovimiento(tablaMuestra) {
	   var table = document.getElementById(tablaMuestra);
	   var datosJson = [];
	   var vendedorMovi = $('#vendedorMovi').val();
	   var empresaMovi = $('#empresaMovi').val();
	   var prendaMovi = $('#prendaMovi').val();
	   var validacion=true;
	   var validador = 0;
	   foreach(table, 'tr:not(:first-child)', function(row) {validador=1});
	   if(vendedorMovi=="error" || empresaMovi=="error" || validador==0){
		   console.log("faltan datos");
		   Swal.fire({
				icon: 'error',
				title: 'Error',
				text: 'Todos los campos deben de estar llenos!',
				showConfirmButton: false,
		        timer: 3500
			  })
			  
			validacion=false;

	   }
	   
	   if (table) {
		   foreach(table, 'tr:not(:first-child)', function(row) {
			   
			if(validacion==true){
	         var record = {codigoBarras: $('#codigoBarras').text(), nombreMuestra: $('#nombreMuestra').text(), idmuestra: $('#idMuestras').val()};
	         datosJson.push(record);
	  	   console.log("entro correctamente");
			}
	      });
			
	   }

	   if(validacion==true){
		   Swal.fire({
				icon: 'success',
				title: 'Movimiento Agregado',
				text: '¡Se ha agregado un nuevo movimiento!',
				showConfirmButton: false,
		        timer: 2000
			  })
		   $.ajax({
			  
			   method: "POST",
			   url: "/guardarNuevoMovimiento",
			   data:{
				   "_csrf": $('#token').val(),
				   vendedor: vendedorMovi,
				   empresa: empresaMovi,
				   prenda:prendaMovi,
				   "object_muestras": JSON.stringify(datosJson)
			   },
			   
			   success: (data) => {
				   
					  
					  location.href = "/movimientos";
			   },
			   error: (e) =>{
			   }
			   
			   
		   });
	   
	   
	   }
	   
	   return datosJson;

	}
  
  

function detalleMuestras(id){
	$('#borrarTabla').remove();
	$('#crearTabla').append("<div class='modal-body' id='borrarTabla'>" +
								"<div class='form-check'>" +
									"<input type='checkbox' class='form-check-input' id='selectAll'>" +
									"<label class='form-check-label' for='selectAll'>Seleccionar todo</label>" +
								"</div>" +
								"<br>" +
								"<table class='table table-striped table-bordered' id='tablaTraspasoinfo'>" +
									"<thead>" +
										"<tr>" +
											"<th></th>" +
											"<th>C&oacute;digo de barras</th>" +
											"<th>Muestra</th>" +
											"<th>Fecha de salida</th>" +
											"<th>Entregado por</th>" +
											"<th>Fecha de devoluci&oacute;n</th>" +
											"<th>Recibido por</th>" +
											"<th>Recargos(d&iacute;as)</th>" +
											"<th>Estatus</th>" +
										"</tr>" +
									"</thead>" +
								"</table>" +
							"</div>");
	
	$.ajax({
		
		method:"POST",
		url: "/listDetalleMuestras",
		data:{
			"_csrf": $('#token').val(),
			idMovi:id
		},
		success:(data) => {
		/* lista de estatus en la tabla de muestras
		 * 
		 * 1 = "Pendiente de recoger"
		 * 2 = "Cancelado"
		 * 3 = "Devuelto"
		 * 4 = "Entregado a vendedor" con checkBox en la tabla
		 * 5 = "Entregado a vendedor" sin checkBox en la tabla
		 * 6 = "Traspaso" con checkBox en la tabla
		 * 7 = "Traspaso" sin checkBox en la tabla
		 * 8 = "Prestado a empresa" con checkBox en la tabla
		 * 9 = "Prestado a empresa" sin checkBox en la tabla
		 * 10= "Devuelto con recargos"
		 **********/
			var a;
		    var b = [];
			
			for (i in data){
				console.log(data);
				var check;
				var estatus;
				var validador1 = data[i].fecha_salida;
				var validador2 = data[i].entregadaPor;
				var validador3 = data[i].fecha_devolucion;
				var validador4 = data[i].recibidaPor;
				var validador5 = data[i].recargos;
				if(data[i].fecha_salida==null){validador1="";}
				if(data[i].entregadaPor==null){validador2="";}
				if(data[i].fecha_devolucion==null){validador3="";}
				if(data[i].recibidaPor==null){validador4="";}
				if(data[i].recargos==null){validador5="";}
					
				if(data[i].estatus== 4 || data[i].estatus== 6 || data[i].estatus== 8){
					check="<td class='tdcenter' id='checks'>" +
          			"<div class='form-check'>" +
          				"<input class='form-check-input' type='checkbox' name='checkmuestra"+data[i].idMovimientoMuestraDetalle+"' value="+data[i].idMovimientoMuestraDetalle+">" +
          			"</div></td>";
					lista[i]= data[i].idMovimientoMuestraDetalle;
				}
				else{
					check="<td id='check'></td>";
				}
				
				if(data[i].estatus==1) {estatus="Pendiente de recoger";}
				if(data[i].estatus==2) {estatus="Cancelado";}
				if(data[i].estatus==3) {estatus="Devuelto";}
				if(data[i].estatus==4) {estatus="Entregado a vendedor";}
				if(data[i].estatus==5) {estatus="Entregado a vendedor";}
				if(data[i].estatus==6) {estatus="Traspaso";}
				if(data[i].estatus==7) {estatus="Traspaso";}
				if(data[i].estatus==8) {estatus="Prestado a empresa";}
				if(data[i].estatus==9) {estatus="Prestado a empresa";}
				if(data[i].estatus==10){estatus="Devuelto con recargos";}
				
				a= ["<tr>"+
			    		check,
						"<td>"+data[i].codigoBarras+"</td>",
						"<td>"+data[i].nombreMuestra+"</td>",
						"<td>"+validador1+"</td>",
						"<td>"+validador2+"</td>",
						"<td>"+validador3+"</td>",
						"<td>"+validador4+"</td>",
						"<td>"+validador5+"</td>",
						"<td>"+estatus+"</td>"+
					"<tr>"];
				b.push(a);
			}
			//$('#tablaTraspasoinfo').append(a);
			$('#tablaTraspasoinfo').DataTable({
				"data":	b,
		        "ordering": false,
		        "pageLength": 5,
		        "lengthMenu": [
		            [5, 10, 25, 50, 100],
		            [5, 10, 25, 50, 100]
		        ],
		        "language": {
		            "sProcessing": "Procesando...",
		            "sLengthMenu": "Mostrar _MENU_ registros",
		            "sZeroRecords": "No se encontraron resultados",
		            "sEmptyTable": "Ningún dato disponible en esta tabla =(",
		            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
		            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
		            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
		            "sInfoPostFix": "",
		            "sSearch": "Buscar:",
		            "sUrl": "",
		            "sInfoThousands": ",",
		            "sLoadingRecords": "Cargando...",
		            "oPaginate": {
		                "sFirst": "Primero",
		                "sLast": "Último",
		                "sNext": "Siguiente",
		                "sPrevious": "Anterior"
		            },
		            "oAria": {
		                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
		                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
		            },
		            "buttons": {
		                "copy": "Copiar",
		                "colvis": "Visibilidad"
		            }
		        }
		    });
			
			
			
		},
		error: (e) =>{
			
		}
	})	
	
	
	$('#infoTraspaso').modal('toggle');
}


function cancelarSolicitud(idMovimiento){
	Swal.fire({
		  title: '¿Deseas cancelar la solicitud?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
			if (result.value) {
				$.ajax({
				
					method:"POST",
					url:"/cancelarMovimiento",
					data: {
					    	"_csrf": $('#token').val(),
					    	idMovi: idMovimiento
					},
					
					success: (data)=> {
							console.log("si entra hasta aca");
							location.href = "/movimientos";
					},
					error: (e) => {
					}
					
				})
		    Swal.fire(
		      'Correcto',
		      'Solicitud cancelada correctamente',
		      'success'
		    )
		  }
		});
	
}
function entregarSolicitud(idMovimiento){
	console.log(idMovimiento);
	Swal.fire({
		  title: '¿Solicitud entregada?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
			if (result.value) {
			$.ajax({
			
				method:"POST",
				url:"/entregadoVendedor",
				data: {
				    	"_csrf": $('#token').val(),
				    	idMovi: idMovimiento
				},
				
				success: (data)=> {
						console.log("si entra hasta aca");
						location.href = "/movimientos";
				},
				error: (e) => {
				}
				
			})

		    Swal.fire(
		      'Correcto',
		      'Solicitud entregada correctamente',
		      'success'
		    )
		  }
		});
}
function devueltoSolicitud(idMovimiento){
	Swal.fire({
		  title: '¿Prestamo devuelto completo?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
			if (result.value) {
				$.ajax({
				
					method:"POST",
					url:"/devolverMovimiento",
					data: {
					    	"_csrf": $('#token').val(),
					    	idMovi: idMovimiento
					},
					
					success: (data)=> {
							console.log("si entra hasta aca");
							location.href = "/movimientos";
					},
					error: (e) => {
					}
					
				})
		    Swal.fire(
		      'Correcto',
		      'Prestamo entregado correctamente',
		      'success'
		    )
		  }
		});
}


function devueltoIndividualSolicitud(tablaTraspasoinfo){
	console.log(" entra a este sweet");
	var table = document.getElementById(tablaTraspasoinfo);
	var equis;
	var contador = 0;
	var listaMuestras = [];
	var filtered = lista.filter(function(el) { return el; });
	
	console.log(filtered);
	foreach(table, 'tr', function(row) {
		
		if($('#checks')){
			if($('input:checkbox[name=checkmuestra'+filtered[contador]+']:checked')){
				
				equis = $('input:checkbox[name=checkmuestra'+filtered[contador]+']:checked').val();
				console.log(equis);
				contador++;
				listaMuestras[contador]=equis;
			}
		}

		console.log("entra al foreach");
	});
	
	filtered = listaMuestras.filter(function(el) { return el; });
	console.log(filtered);
	var dato = filtered.toString();

	Swal.fire({
		  title: '¿Muestras devueltas?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) { 
			$.ajax({
				method:"POST",
				url:"/devolverIndividual",
				data:{
					"_csrf": $('#token').val(),
					idMuestras:	dato			
				},
				success:(data) => {
					
					location.href = "/movimientos";
				}
			});
		    Swal.fire(
		      'Correcto',
		      'Muestras devueltas correctamente',
		      'success'
		    )
		  }
		});
}


function prestamoSolicitud(tablaTraspasoinfo){
	var table = document.getElementById(tablaTraspasoinfo);
	var equis;
	var contador = 0;
	var listaMuestras = [];
	var filtered = lista.filter(function(el) { return el; });
	
	console.log(filtered);
	foreach(table, 'tr', function(row) {
		
		if($('#checks')){
			if($('input:checkbox[name=checkmuestra'+filtered[contador]+']:checked')){
				
				equis = $('input:checkbox[name=checkmuestra'+filtered[contador]+']:checked').val();
				console.log(equis);
				contador++;
				listaMuestras[contador]=equis;
			}
		}

		console.log("entra al foreach");
	});
	
	filtered = listaMuestras.filter(function(el) { return el; });
	console.log(filtered);
	var dato = filtered.toString();

	Swal.fire({
		  title: '¿Muestras prestadas a empresa?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) {
			$.ajax({
				method:"POST",
				url:"/prestamoEmpresa",
				data:{
					"_csrf": $('#token').val(),
					idMuestras:	dato			
				},
				success:(data) => {
					
					location.href = "/movimientos";
				}
			});
		    Swal.fire(
		      'Correcto',
		      'Actualizaci&oacute;n correcta',
		      'success'
		    )
		  }
		});
}

function traspasoSolicitud(tablaTraspasoinfo){
	var table = document.getElementById(tablaTraspasoinfo);
	var equis;
	var contador = 0;
	var listaMuestras = [];
	var filtered = lista.filter(function(el) { return el; });
	var vendedorTraspaso = $('#vendedorTraspaso').val();
	
	console.log(filtered);
	foreach(table, 'tr', function(row) {
		
		if($('#checks')){
			if($('input:checkbox[name=checkmuestra'+filtered[contador]+']:checked')){
				
				equis = $('input:checkbox[name=checkmuestra'+filtered[contador]+']:checked').val();
				console.log(equis);
				contador++;
				listaMuestras[contador]=equis;
			}
		}

		console.log("entra al foreach");
	});
	
	filtered = listaMuestras.filter(function(el) { return el; });
	console.log(filtered);
	var dato = filtered.toString();

	Swal.fire({
		  title: '¿Seguro que desea Traspasar?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) {
			  
			$.ajax({
				method:"POST",
				url:"/traspasoSolicitud",
				data:{
					"_csrf": $('#token').val(),
					idMuestras:	dato,
					nuevoVendedor: vendedorTraspaso
				},
				success:(data) => {
					
					location.href = "/movimientos";
				}
			});
		    Swal.fire(
		      'Correcto',
		      'Actualizaci&oacute;n correcta',
		      'success'
		    )
		  }
		});
}