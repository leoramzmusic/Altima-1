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
  
  

function listarTabla(){
	$('#tablaTraspasoinfo').DataTable({
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
		      'Solicitud cancelado correctamente',
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
function devueltoIndividualSolicitud(idMovimiento){
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
		    Swal.fire(
		      'Correcto',
		      'Muestras devueltas correctamente',
		      'success'
		    )
		  }
		});
}
function prestamoSolicitud(idMovimiento){
	Swal.fire({
		  title: '¿Muestras prestadas a la empresa?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) {
		    Swal.fire(
		      'Correcto',
		      'Actualizaci&oacute;n correcta',
		      'success'
		    )
		  }
		});
}