 
//Habilitar form de SweetAlert2
$('#detalleMarcas').on('shown.bs.modal', function() {
     $(document).off('focusin.modal');
 });
// //////////////////////7



// Agregar Marca
function agregarMarca() {
	 Swal.fire({
	      title: 'Agregar marca',
		    html:'<div class="row">'+
	        '<div class="form-group col-sm-12">'+
	          '<label for="pedidonom">Nombre de la marca</label>'+
	          '<input type="text" class="swal2-input" id="marca" placeholder="Parisina">'+
	        '</div>'+
	        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Agregar',
	      confirmButtonColor:'#FFC107',
	    }).then((result) => {
	      if (result.value && document.getElementById("marca").value) {
			    var Marca=document.getElementById("marca").value;
	    	  console.log(result.value);
	    	  console.log("hola");
			   $.ajax({
	        type: "POST",
	        url: "/guardarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'Marca': Marca
	        	// ,'Descripcion':Descripcion
	        }
	       
	    })
	    .done(function( data ) {
	    	
	    	 tablaUsuarios.ajax.reload(null, false);
  });
	    
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'Insertado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	        // /window.setTimeout(function(){location.reload()}, 2000);
	      }
	    })
  }
// Editar Marca
$(document).on('click', '.edit_data', function () {
	  var marca_id = $(this).attr("id");  
		var marca_nombre=$(this).attr("value"); 
Swal.fire({
    title: 'Editar marca',
    html:'<div class="row">'+
    '<div class="form-group col-sm-12">'+
      '<label for="pedidonom">Nombre de la marca</label>'+
      '<input type="text" class="form-control" id="marca" value=" '+marca_nombre+' " placeholder="Rojo">'+
      '<input type="hidden" value=" '+marca_id+' ">'+
    '</div>'+
    '</div>',
    inputAttributes: {
      autocapitalize: 'off'
    },
    showCancelButton: true,
    cancelButtonColor: '#6C757D',
    cancelButtonText: 'Cancelar',
    confirmButtonText: 'Actualizar',
    confirmButtonColor:'#DC3545',
}).then((result) => {
    if (result.value && document.getElementById("marca").value) {
		    var Marca=document.getElementById("marca").value;
  	  console.log(result.value);
		   $.ajax({
      type: "POST",
      url: "/editarcatalogo",
      data: { 
      	 "_csrf": $('#token').val(),
  	'Marca': Marca,
  	'idLookup': marca_id
      	// ,'Descripcion':Descripcion
      }
     
  });
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'editado correctamente',
        showConfirmButton: false,
        timer: 1250
      })
		 window.setTimeout(function(){location.reload()}, 2000);
    }
  })
}
)
  // Dar de baja marca
  function bajarMarca(){
    Swal.fire({
      title: '¿Deseas dar de baja la marca?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Dada de baja correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
  // Reactivar marca
  function reactivarMarca(){
    Swal.fire({
      title: '¿Deseas reactivar la marca?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivada correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detalleColores').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
// Agregar Color
  function agregarColor() {
		 Swal.fire({
		      title: 'Agregar color',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre del color</label>'+
		          '<input type="text" class="swal2-input" id="color" placeholder="Rojo">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#FFC107',
		    }).then((result) => {
		      if (result.value && document.getElementById("color").value) {
				    var Color=document.getElementById("color").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'Color': Color
		        	// ,'Descripcion':Descripcion
		        }
		       
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }
	// Editar color
	$(document).on('click', '.edit_data_color', function () {
		  var color_id = $(this).attr("id");  
			var color_nombre=$(this).attr("value"); 
	Swal.fire({
	    title: 'Editar color',
	    html:'<div class="row">'+
	    '<div class="form-group col-sm-12">'+
	      '<label for="pedidonom">Nombre del color</label>'+
	      '<input type="text" class="form-control" id="color" value=" '+color_nombre+' " placeholder="Rojo">'+
	      '<input type="hidden" value=" '+color_id+' ">'+
	    '</div>'+
	    '</div>',
	    inputAttributes: {
	      autocapitalize: 'off'
	    },
	    showCancelButton: true,
	    cancelButtonColor: '#6C757D',
	    cancelButtonText: 'Cancelar',
	    confirmButtonText: 'Actualizar',
	    confirmButtonColor:'#DC3545',
	}).then((result) => {
	    if (result.value && document.getElementById("color").value) {
			    var Color=document.getElementById("color").value;
	  	  console.log(result.value);
			   $.ajax({
	      type: "POST",
	      url: "/editarcatalogo",
	      data: { 
	      	 "_csrf": $('#token').val(),
	  	'Color': Color,
	  	'idLookup': color_id
	      	// ,'Descripcion':Descripcion
	      }
	     
	  });
	      Swal.fire({
	        position: 'center',
	        icon: 'success',
	        title: 'editado correctamente',
	        showConfirmButton: false,
	        timer: 1250
	      })
			 window.setTimeout(function(){location.reload()}, 2000);
	    }
	  })
	}
	)
  // Dar de baja color
  function bajarColor(){
    Swal.fire({
      title: '¿Deseas dar de baja el color?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#DC3545',
    }).then((result) => {
      if (result.value) {
    	  console.log(result.value);
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Dado de baja correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
  // Reactivar color
  function reactivarColor(){
    Swal.fire({
      title: '¿Deseas reactivar el color?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#DC3545',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivado correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detalleTrazo').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
  
  // Agregar Pieza de Trazo
  function agregarTrazo() {
		 Swal.fire({
		      title: 'Agregar trazo',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre pieza trazo</label>'+
		          '<input type="text" class="swal2-input" id="trazo" placeholder="Cuello">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#28A745',
		    }).then((result) => {
		      if (result.value && document.getElementById("trazo").value) {
				    var Trazo=document.getElementById("trazo").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'PiezaTrazo': Trazo
		        	// ,'Descripcion':Descripcion
		        }
		       
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }
	// Editar Trazo
	$(document).on('click', '.edit_data_trazo', function () {
		  var trazo_id = $(this).attr("id");  
			var trazo_nombre=$(this).attr("value");
		console.log($('#token').val());
	Swal.fire({
	    title: 'Editar pieza trazo',
	    html:'<div class="row">'+
	    '<div class="form-group col-sm-12">'+
	      '<label for="pedidonom">Nombre pieza trazo</label>'+
	      '<input type="text" class="form-control" id="trazo" value=" '+trazo_nombre+' " placeholder="Rojo">'+
	      '<input type="hidden" value=" '+trazo_id+' ">'+
	    '</div>'+
	    '</div>',
	    inputAttributes: {
	      autocapitalize: 'off'
	    },
	    showCancelButton: true,
	    cancelButtonColor: '#6C757D',
	    cancelButtonText: 'Cancelar',
	    confirmButtonText: 'Actualizar',
	    confirmButtonColor:'#28A745',
	}).then((result) => {
	    if (result.value && document.getElementById("trazo").value) {
			    var Trazo=document.getElementById("trazo").value;
	  	  console.log(result.value);
			   $.ajax({
	      type: "POST",
	      url: "/editarcatalogo",
	      data: { 
	      	 "_csrf": $('#token').val(),
	  	'PiezaTrazo': Trazo,
	  	'idLookup': trazo_id
	      	// ,'Descripcion':Descripcion
	      }
	     
	  });
	      Swal.fire({
	        position: 'center',
	        icon: 'success',
	        title: 'editado correctamente',
	        showConfirmButton: false,
	        timer: 1250
	      })
			 window.setTimeout(function(){location.reload()}, 2000);
	    }
	  })
	}
	)
  // Dar de baja pieza de trazo
  function bajarTrazo(){
    Swal.fire({
      title: '¿Deseas dar de baja la pieza de trazo?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#28A745',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Dada de baja correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
  // Reactivar pieza de trazo
  function reactivarTrazo(){
    Swal.fire({
      title: '¿Deseas reactivar la pieza de trazo?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#28A745',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivada correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detallePrenda').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
  // Agregar Familia de prendas
  function agregarPrenda() {
		 Swal.fire({
		      title: 'Agregar familia prenda',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre de la familia prendas</label>'+
		          '<input type="text" class="swal2-input" id="familia" placeholder="Parisina">'+
		        '</div>'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Descripcion</label>'+
		          '<input type="text" class="swal2-input" id="descripcion" placeholder="Parisina">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#17a2b8',
		    }).then((result) => {
		      if (result.value && document.getElementById("familia").value && document.getElementById("descripcion").value) {
				    var FamiliaPrenda=document.getElementById("familia").value;
				    var Descripcion=document.getElementById("descripcion").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaPrenda': FamiliaPrenda,
		        	'Descripcion' :Descripcion
		        	
		        	// ,'Descripcion':Descripcion
		        }
		       
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }
  
	// Editar Prenda
  
  
  function editarPrenda(e) {
		 var descr=e.getAttribute("descripcion");
		
		console.log(descr);
		 Swal.fire({
		      title: 'Editar prenda',
			   html:'<div class="row">'+
			        '<div class="form-group col-sm-12">'+
			          '<label for="pedidonom">Nombre de la familia prendas</label>'+
			          '<input type="text" value=" '+e.getAttribute("nombre")+' " class="swal2-input" id="nombre" placeholder="Parisina">'+
			        '</div>'+
			        '<div class="form-group col-sm-12">'+
			          '<label for="pedidonom">Descripcion</label>'+
			          '<input type="text" class="swal2-input" id="descripcion" placeholder="Parisina" value=" '+e.getAttribute("descripcion")+' "> '+
			          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
			        '</div>'+
			        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Actualizar',
		      confirmButtonColor:'#FFC107',
		    }).then((result) => {
		      if (result.value && document.getElementById("nombre").value && document.getElementById("descripcion").value && document.getElementById("idlookup").value) {
				    var FamiliaPrenda=document.getElementById("nombre").value;
				    var Descripcion=document.getElementById("descripcion").value;
				    var idLookup=document.getElementById("idlookup").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/editarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaPrenda': FamiliaPrenda,
		        	'Descripcion' :Descripcion,
		        	'idLookup' :idLookup
		        	// ,'Descripcion':Descripcion
		        }
		       
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'editado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }
  // Dar de baja prenda
  function bajarPrenda(){
    Swal.fire({
      title: '¿Deseas dar de baja la familia de prenda',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#17A2B8',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Dada de baja correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
  // Reactivar prenda
  function reactivarPrenda(){
    Swal.fire({
      title: '¿Deseas reactivar la familia de prenda?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#17A2B8',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivada correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detalleGenero').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
  // Agregar familia de genero
  function agregarGenero() {
		 Swal.fire({
		      title: 'Agregar genero',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre del genero</label>'+
		          '<input type="text" class="swal2-input" id="genero" placeholder="masculino">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#17a2b8',
		    }).then((result) => {
		      if (result.value && document.getElementById("genero").value) {
				    var Genero=document.getElementById("genero").value;
			
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaGenero': Genero
		        	
		        	// ,'Descripcion':Descripcion
		        }
		       
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }

	// Editar genero


function editarGenero(e) {
		 var descr=e.getAttribute("descripcion");
		
		console.log(descr);
		 Swal.fire({
		      title: 'Editar genero',
			   html:'<div class="row">'+
			        '<div class="form-group col-sm-12">'+
			          '<label for="pedidonom">Nombre de genero</label>'+
			          '<input type="text" value=" '+e.getAttribute("nombre")+' " class="swal2-input" id="nombre" placeholder="Parisina">'+
			        '</div>'+
			        '<div class="form-group col-sm-12">'+
			        
			          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
			        '</div>'+
			        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Actualizar',
		      confirmButtonColor:'#FFC107',
		    }).then((result) => {
		      if (result.value && document.getElementById("nombre").value  && document.getElementById("idlookup").value) {
				    var FamiliaGenero=document.getElementById("nombre").value;
				   
				    var idLookup=document.getElementById("idlookup").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/editarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaGenero': FamiliaGenero,
		        	'idLookup' :idLookup
		        	// ,'Descripcion':Descripcion
		        }
		       
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'editado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }
  // Dar de baja familia de genero
  function bajarGenero(){
    Swal.fire({
      title: '¿Deseas dar de baja la familia de g&eacute;nero',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#DC3545',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Dada de baja correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
  // Reactivar familia de genero
  function reactivarGenero(){
    Swal.fire({
      title: '¿Deseas reactivar la familia de g&eacute;nero?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#DC3545',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivada correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detalleMantenimiento').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
  // Agregar composicion
  function agregarComposicion() {
		 Swal.fire({
		      title: 'Agregar composición',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre de composición</label>'+
		          '<input type="text" class="swal2-input" id="composicion" placeholder="100% algodon">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#17a2b8',
		    }).then((result) => {
		      if (result.value && document.getElementById("composicion").value) {
				    var Composicion=document.getElementById("composicion").value;
			
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaComposicion': Composicion
		        	
		        	// ,'Descripcion':Descripcion
		        }
		       
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }

	// Editar genero


function editarComposicion(e) {
		 var descr=e.getAttribute("descripcion");
		
		console.log(descr);
		 Swal.fire({
		      title: 'Editar Composición',
			   html:'<div class="row">'+
			        '<div class="form-group col-sm-12">'+
			          '<label for="pedidonom">Nombre composicón</label>'+
			          '<input type="text" value=" '+e.getAttribute("nombre")+' " class="swal2-input" id="nombre" placeholder="Parisina">'+
			        '</div>'+
			        '<div class="form-group col-sm-12">'+
			          
			          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
			        '</div>'+
			        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Actualizar',
		      confirmButtonColor:'#FFC107',
		    }).then((result) => {
		      if (result.value && document.getElementById("nombre").value  && document.getElementById("idlookup").value) {
				    var FamiliaComposicion=document.getElementById("nombre").value;
				   
				    var idLookup=document.getElementById("idlookup").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/editarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaComposicion': FamiliaComposicion,
		        	'idLookup' :idLookup
		        	// ,'Descripcion':Descripcion
		        }
		       
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'editado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }
// Dar de baja familia de genero
function bajarComposicion(){
 Swal.fire({
   title: '¿Deseas dar de baja la familia de g&eacute;nero',
   icon: 'warning',
   showCancelButton: true,
   cancelButtonColor: '#6C757D',
   cancelButtonText: 'Cancelar',
   confirmButtonText: 'Dar de baja',
   confirmButtonColor:'#DC3545',
 }).then((result) => {
   if (result.value) {
     Swal.fire({
       position: 'center',
       icon: 'success',
       title: 'Dada de baja correctamente',
       showConfirmButton: false,
       timer: 1250
     })
   }
 })
}
// Reactivar familia de genero
function reactivarComposicion(){
 Swal.fire({
   title: '¿Deseas reactivar la familia de g&eacute;nero?',
   icon: 'warning',
   showCancelButton: true,
   cancelButtonColor: '#6C757D',
   cancelButtonText: 'Cancelar',
   confirmButtonText: 'Activar',
   confirmButtonColor:'#DC3545',
 }).then((result) => {
   if (result.value) {
     Swal.fire({
       position: 'center',
       icon: 'success',
       title: 'Reactivada correctamente',
       showConfirmButton: false,
       timer: 1250
     })
   }
 })
}
  // ////////////////////////
// Habilitar form de SweetAlert2
$('#detalleCuidado').on('shown.bs.modal', function() {
     $(document).off('focusin.modal');
 });
function agregarCuidado() {
	 Swal.fire({
	      title: 'Agregar instrucción de cuidado',
		    html:'<div class="row">'+
	        '<div class="form-group col-sm-12">'+
	          '<label for="pedidonom">Nombre instrucción de cuidado</label>'+
	          '<input type="text" class="swal2-input" id="cuidado" placeholder="lavar a mano">'+
	        '</div>'+
	        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Agregar',
	      confirmButtonColor:'#17a2b8',
	    }).then((result) => {
	      if (result.value && document.getElementById("cuidado").value) {
			    var Cuidado=document.getElementById("cuidado").value;
		
	    	  console.log(result.value);
			   $.ajax({
	        type: "POST",
	        url: "/guardarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'InstruccionCuidado': Cuidado
	        	
	        	// ,'Descripcion':Descripcion
	        }
	       
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'Insertado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	        window.setTimeout(function(){location.reload()}, 2000);
	      }
	    })
 }

// Editar genero


function editarCuidado(e) {
	 var descr=e.getAttribute("descripcion");
	
	console.log(descr);
	 Swal.fire({
	      title: 'Editar instruccion de cuidado',
		   html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre instrucción de cuidado</label>'+
		          '<input type="text" value=" '+e.getAttribute("nombre")+' " class="swal2-input" id="nombre" placeholder="Parisina">'+
		        '</div>'+
		        '<div class="form-group col-sm-12">'+
		         
		          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
		        '</div>'+
		        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Actualizar',
	      confirmButtonColor:'#FFC107',
	    }).then((result) => {
	      if (result.value && document.getElementById("nombre").value  && document.getElementById("idlookup").value) {
			    var InstruccionCuidado=document.getElementById("nombre").value;
			   
			    var idLookup=document.getElementById("idlookup").value;
	    	  console.log(result.value);
			   $.ajax({
	        type: "POST",
	        url: "/editarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'InstruccionCuidado': InstruccionCuidado,
	        	'idLookup' :idLookup
	        	// ,'Descripcion':Descripcion
	        }
	       
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'editado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	        window.setTimeout(function(){location.reload()}, 2000);
	      }
	    })
 }
// Dar de baja familia de genero
function bajarCuidado(){
Swal.fire({
 title: '¿Deseas dar de baja la familia de g&eacute;nero',
 icon: 'warning',
 showCancelButton: true,
 cancelButtonColor: '#6C757D',
 cancelButtonText: 'Cancelar',
 confirmButtonText: 'Dar de baja',
 confirmButtonColor:'#DC3545',
}).then((result) => {
 if (result.value) {
   Swal.fire({
     position: 'center',
     icon: 'success',
     title: 'Dada de baja correctamente',
     showConfirmButton: false,
     timer: 1250
   })
 }
})
}
// Reactivar familia de genero
function reactivarCuidado(){
Swal.fire({
 title: '¿Deseas reactivar la familia de g&eacute;nero?',
 icon: 'warning',
 showCancelButton: true,
 cancelButtonColor: '#6C757D',
 cancelButtonText: 'Cancelar',
 confirmButtonText: 'Activar',
 confirmButtonColor:'#DC3545',
}).then((result) => {
 if (result.value) {
   Swal.fire({
     position: 'center',
     icon: 'success',
     title: 'Reactivada correctamente',
     showConfirmButton: false,
     timer: 1250
   })
 }
})
}
