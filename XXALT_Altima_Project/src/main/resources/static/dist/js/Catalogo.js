 
//Habilitar form de SweetAlert2
$('#detalleMarcas').on('shown.bs.modal', function() {
     $(document).off('focusin.modal');
 });

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
        inputAttributes: {
          autocapitalize: 'off'
        },
        showCancelButton: true,
        cancelButtonColor: '#6C757D',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Agregar',
        confirmButtonColor:'#FFC107'
        }).then(function (Marca,Descripcion,response) {
    	  if (document.getElementById("marca").value) {
    		
    		  var Marca=document.getElementById("marca").value;
    		 // var Descripcion=document.getElementById("descripcion").value;
    		  }
    	  else {
    	         
    		  Swal.fire({
                  title: ` ingrese datos antes de enviar`
                 
                })
    		  throw new Error(response.statusText)
    	      }
        $.ajax({
        type: "POST",
        url: "/guardarcatalogo",
        data: { 
        	 "_csrf": $('#token').val(),
        	'Marca': Marca
        	// ,'Descripcion':Descripcion
        },
        	
        cache: false,
        success: function(response) {
        	 Swal.fire({
                 title: ` Datos enviados correctamente`
                
               })
        },
        failure: function (response) {
        	 Swal.fire({
                 title: ` fallo`
                
               })
        }
    });
        window.setTimeout(function(){location.reload()}, 2000);
}, 
function (dismiss) {
  if (dismiss === "cancel") {
    swal(
      "Cancelled",
        "Canceled Note",
      "error"
    )
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
        '<label for="pedidonom">Nombre del color</label>'+
        '<input type="text" class="form-control" id="marca" value='+marca_nombre+' placeholder="Rojo">'+
        '<input type="hidden" value='+marca_id+'>'+
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
  }).then(function (Marca,response) {
	  if (document.getElementById("marca").value) {
		
		  var Marca=document.getElementById("marca").value;
		 // var Descripcion=document.getElementById("descripcion").value;
		  }
	  else {
	         
		  Swal.fire({
              title: ` ingrese datos antes de enviar`
             
            })
		  throw new Error(response.statusText)
	      }
	  if(document.getElementById("marca").value){
    $.ajax({
    type: "POST",
    url: "/editarcatalogo",
    data: { 
    	 "_csrf": $('#token').val(),
    	'Marca': Marca,
    	'idLookup': marca_id
    	// ,'Descripcion':Descripcion
    },
    	
    cache: false,
    success: function(response) {
    	 Swal.fire({
             title: ` Datos enviados correctamente`
            	
           })
    },
    failure: function (response) {
    	 Swal.fire({
             title: ` fallo`
            
           })
    }
});
    window.setTimeout(function(){location.reload()}, 2000);
    // /window.location.href("/catalogos");
    // /window.location.reload();
	  }
}, 
function (dismiss) {
if (dismiss === "cancel") {
swal(
  "Cancelled",
    "Canceled Note",
  "error"
)
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
	        inputAttributes: {
	          autocapitalize: 'off'
	        },
	        showCancelButton: true,
	        cancelButtonColor: '#6C757D',
	        cancelButtonText: 'Cancelar',
	        confirmButtonText: 'Agregar',
	        confirmButtonColor:'#dc3545'
	        }).then(function (Color,Descripcion,response) {
	    	  if (document.getElementById("color").value) {
	    		
	    		  var Color=document.getElementById("color").value;
	    		 // var Descripcion=document.getElementById("descripcion").value;
	    		  }
	    	  else {
	    	         
	    		  Swal.fire({
	                  title: ` ingrese datos antes de enviar`
	                 
	                })
	    		  throw new Error(response.statusText)
	    	      }
	        $.ajax({
	        type: "POST",
	        url: "/guardarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'Color': Color
	        	// ,'Descripcion':Descripcion
	        },
	        	
	        cache: false,
	        success: function(response) {
	        	 Swal.fire({
	                 title: ` Datos enviados correctamente`
	                
	               })
	        },
	        failure: function (response) {
	        	 Swal.fire({
	                 title: ` fallo`
	                
	               })
	        }
	    });
	        window.setTimeout(function(){location.reload()}, 2000);
	}, 
	function (dismiss) {
	  if (dismiss === "cancel") {
	    swal(
	      "Cancelled",
	        "Canceled Note",
	      "error"
	    )
	  }
	})
	  }
// Editar Color
  $(document).on('click', '.edit_data222', function () {
	  var marca_id = $(this).attr("id");  
		var marca_nombre=$(this).attr("value"); 
      Swal.fire({
          title: 'Editar color',
          html:'<div class="row">'+
          '<div class="form-group col-sm-12">'+
            '<label for="pedidonom">Nombre del color</label>'+
            '<input type="text" class="form-control" value='+marca_nombre+' placeholder="Rojo">'+
            '<input type="hidden" value='+marca_id+'>'+
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
          showLoaderOnConfirm: true,
          preConfirm: (login) => {
            return fetch(`//api.github.com/users/${login}`)
              .then(response => {
                if (!response.ok) {
                  throw new Error(response.statusText)
                }
                return response.json()
              })
              .catch(error => {
                Swal.showValidationMessage(
                  `Error: ${error}`
                )
              })
          },
          allowOutsideClick: () => !Swal.isLoading()
        }).then((result) => {
          if (result.value) {
            Swal.fire({
              title: `${result.value.login}'s avatar`,
              imageUrl: result.value.avatar_url
            })
          }
        })
    })
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
        title: 'Agregar pieza de trazo',
        html:'<div class="row">'+
        '<div class="form-group col-sm-12">'+
          '<label for="pedidonom">Nombre de la pieza trazo</label>'+
          '<input type="text" class="form-control" id="trazoAgregar" placeholder="Cuello">'+
        '</div>'+
        '</div>',
        inputAttributes: {
          autocapitalize: 'off'
        },
        showCancelButton: true,
        cancelButtonColor: '#6C757D',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Agregar',
        confirmButtonColor:'#28A745',
        showLoaderOnConfirm: true,
        preConfirm: (login) => {
          return fetch(`//api.github.com/users/${login}`)
            .then(response => {
              if (!response.ok) {
                throw new Error(response.statusText)
              }
              return response.json()
            })
            .catch(error => {
              Swal.showValidationMessage(
                `Error: ${error}`
              )
            })
        },
        allowOutsideClick: () => !Swal.isLoading()
      }).then((result) => {
        if (result.value) {
          Swal.fire({
            title: `${result.value.login}'s avatar`,
            imageUrl: result.value.avatar_url
          })
        }
      })
  }
// _ar pieza trazo
  function editarTrazo() {
      Swal.fire({
          title: 'Editar pieza trazo',
          html:'<div class="row">'+
          '<div class="form-group col-sm-12">'+
            '<label for="pedidonom">Nombre de la pieza trazo</label>'+
            '<input type="text" class="form-control" id="trazoEditar" placeholder="Cuello">'+
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
          showLoaderOnConfirm: true,
          preConfirm: (login) => {
            return fetch(`//api.github.com/users/${login}`)
              .then(response => {
                if (!response.ok) {
                  throw new Error(response.statusText)
                }
                return response.json()
              })
              .catch(error => {
                Swal.showValidationMessage(
                  `Error: ${error}`
                )
              })
          },
          allowOutsideClick: () => !Swal.isLoading()
        }).then((result) => {
          if (result.value) {
            Swal.fire({
              title: `${result.value.login}'s avatar`,
              imageUrl: result.value.avatar_url
            })
          }
        })
    }
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
        title: 'Agregar familia de prenda',
        html:'<div class="row">'+
        '<div class="form-group col-sm-12">'+
          '<label for="pedidonom">Nombre de la familia de prendas</label>'+
          '<input type="text" class="form-control" id="prendaAgregarNombre" placeholder="Abrigos">'+
        '</div>'+
        '</div>'+
        '<div class="form-group col-sm-12">'+
        '<label for="pedidonom">Descripcion</label>'+
        '<textarea class="form-control" id="prendaAgregarDescripcion" placeholder="Especificar" rows="3"></textarea>'+
      '</div>'+
      '</div>',
        inputAttributes: {
          autocapitalize: 'off'
        },
        showCancelButton: true,
        cancelButtonColor: '#6C757D',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Agregar',
        confirmButtonColor:'#17A2B8',
        showLoaderOnConfirm: true,
        preConfirm: (login) => {
          return fetch(`//api.github.com/users/${login}`)
            .then(response => {
              if (!response.ok) {
                throw new Error(response.statusText)
              }
              return response.json()
            })
            .catch(error => {
              Swal.showValidationMessage(
                `Error: ${error}`
              )
            })
        },
        allowOutsideClick: () => !Swal.isLoading()
      }).then((result) => {
        if (result.value) {
          Swal.fire({
            title: `${result.value.login}'s avatar`,
            imageUrl: result.value.avatar_url
          })
        }
      })
  }
// Editar familia de prendas
  function editarPrenda() {
      Swal.fire({
          title: 'Editar familia de prendas',
          html:'<div class="row">'+
          '<div class="form-group col-sm-12">'+
            '<label for="pedidonom">Nombre de la familia de prendas</label>'+
            '<input type="text" class="form-control" id="prendaEditarNombre" placeholder="Abrigos">'+
          '</div>'+
          '</div>'+
          '<div class="form-group col-sm-12">'+
          '<label for="pedidonom">Descripcion</label>'+
          '<textarea class="form-control" id="prendaEditarDescripcion" placeholder="Especificar" rows="3"></textarea>'+
        '</div>'+
        '</div>',
          inputAttributes: {
            autocapitalize: 'off'
          },
          showCancelButton: true,
          cancelButtonColor: '#6C757D',
          cancelButtonText: 'Cancelar',
          confirmButtonText: 'Actualizar',
          confirmButtonColor:'#17A2B8',
          showLoaderOnConfirm: true,
          preConfirm: (login) => {
            return fetch(`//api.github.com/users/${login}`)
              .then(response => {
                if (!response.ok) {
                  throw new Error(response.statusText)
                }
                return response.json()
              })
              .catch(error => {
                Swal.showValidationMessage(
                  `Error: ${error}`
                )
              })
          },
          allowOutsideClick: () => !Swal.isLoading()
        }).then((result) => {
          if (result.value) {
            Swal.fire({
              title: `${result.value.login}'s avatar`,
              imageUrl: result.value.avatar_url
            })
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
        title: 'Agregar familia de g&eacute;nero',
        html:'<div class="row">'+
        '<div class="form-group col-sm-12">'+
          '<label>Nombre de la familia de g&eacute;nero</label>'+
          '<input type="text" class="form-control" id="generoAgregar" placeholder="Unisex">'+
        '</div>'+
        '</div>',
        inputAttributes: {
          autocapitalize: 'off'
        },
        showCancelButton: true,
        cancelButtonColor: '#6C757D',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Agregar',
        confirmButtonColor:'#DC3545',
        showLoaderOnConfirm: true,
        preConfirm: (login) => {
          return fetch(`//api.github.com/users/${login}`)
            .then(response => {
              if (!response.ok) {
                throw new Error(response.statusText)
              }
              return response.json()
            })
            .catch(error => {
              Swal.showValidationMessage(
                `Error: ${error}`
              )
            })
        },
        allowOutsideClick: () => !Swal.isLoading()
      }).then((result) => {
        if (result.value) {
          Swal.fire({
            title: `${result.value.login}'s avatar`,
            imageUrl: result.value.avatar_url
          })
        }
      })
  }
// Editar familia de genero
  function editarGenero() {
      Swal.fire({
          title: 'Editar familia de g&eacute;nero',
          html:'<div class="row">'+
          '<div class="form-group col-sm-12">'+
            '<label>Nombre de la familia de g&eacute;nero</label>'+
            '<input type="text" class="form-control" id="generoEditar" placeholder="Unisex">'+
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
          showLoaderOnConfirm: true,
          preConfirm: (login) => {
            return fetch(`//api.github.com/users/${login}`)
              .then(response => {
                if (!response.ok) {
                  throw new Error(response.statusText)
                }
                return response.json()
              })
              .catch(error => {
                Swal.showValidationMessage(
                  `Error: ${error}`
                )
              })
          },
          allowOutsideClick: () => !Swal.isLoading()
        }).then((result) => {
          if (result.value) {
            Swal.fire({
              title: `${result.value.login}'s avatar`,
              imageUrl: result.value.avatar_url
            })
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
        title: 'Agregar composici&oacute;n',
        html:'<div class="row">'+
        '<div class="form-group col-sm-12">'+
          '<label>Nombre de la composici&oacute;n</label>'+
          '<input type="text" class="form-control" id="composicionAgregar" placeholder="Algod&oacute;n">'+
        '</div>'+
        '<div class="form-group col-sm-12">'+
	       '<label for="composicionCuidado">Instrucciones de cuidado</label>'+
	       '<select class="form-control" id="composicionCuidado">'+
        	 '<option>1</option>'+
	         '<option>2</option>'+
	         '<option>3</option>'+
	         '<option>4</option>'+
	         '<option>5</option>'+
	       '</select>'+
	    '</div>'+
        '</div>',
        inputAttributes: {
          autocapitalize: 'off'
        },
        showCancelButton: true,
        cancelButtonColor: '#6C757D',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Agregar',
        confirmButtonColor:'#FFC107',
        showLoaderOnConfirm: true,
        preConfirm: (login) => {
          return fetch(`//api.github.com/users/${login}`)
            .then(response => {
              if (!response.ok) {
                throw new Error(response.statusText)
              }
              return response.json()
            })
            .catch(error => {
              Swal.showValidationMessage(
                `Error: ${error}`
              )
            })
        },
        allowOutsideClick: () => !Swal.isLoading()
      }).then((result) => {
        if (result.value) {
          Swal.fire({
            title: `${result.value.login}'s avatar`,
            imageUrl: result.value.avatar_url
          })
        }
      })
  }
// Editar composicion
  function editarComposicion() {
      Swal.fire({
          title: 'Editar composici&oacute;n',
          html:'<div class="row">'+
          '<div class="form-group col-sm-12">'+
            '<label>Nombre de la composici&oacute;n</label>'+
            '<input type="text" class="form-control" id="composicionEditar" placeholder="Algod&oacute;n">'+
          '</div>'+
          '<div class="form-group col-sm-12">'+
	       '<label for="composicionCuidado">Instrucciones de cuidado</label>'+
	       '<select class="form-control" id="composicionCuidado">'+
       	 '<option>1</option>'+
	         '<option>2</option>'+
	         '<option>3</option>'+
	         '<option>4</option>'+
	         '<option>5</option>'+
	       '</select>'+
	    '</div>'+
       '</div>',
          inputAttributes: {
            autocapitalize: 'off'
          },
          showCancelButton: true,
          cancelButtonColor: '#6C757D',
          cancelButtonText: 'Cancelar',
          confirmButtonText: 'Actualizar',
          confirmButtonColor:'#FFC107',
          showLoaderOnConfirm: true,
          preConfirm: (login) => {
            return fetch(`//api.github.com/users/${login}`)
              .then(response => {
                if (!response.ok) {
                  throw new Error(response.statusText)
                }
                return response.json()
              })
              .catch(error => {
                Swal.showValidationMessage(
                  `Error: ${error}`
                )
              })
          },
          allowOutsideClick: () => !Swal.isLoading()
        }).then((result) => {
          if (result.value) {
            Swal.fire({
              title: `${result.value.login}'s avatar`,
              imageUrl: result.value.avatar_url
            })
          }
        })
    }
  // Dar de baja composicion
  function bajarComposicion(){
    Swal.fire({
      title: '¿Deseas dar de baja la composici&oacute;n?',
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
  // Reactivar composicion
  function reactivarComposicion(){
    Swal.fire({
      title: '¿Deseas reactivar la composici&oacute;n?',
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
//Habilitar form de SweetAlert2
  $('#detalleCuidado').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
  // Agregar composicion
  function agregarCuidado() {
    Swal.fire({
        title: 'Agregar instrucci&oacute;n de cuidado',
        html:'<div class="row">'+
        '<div class="form-group col-sm-12">'+
          '<label>Nombre de la instrucci&oacute;n</label>'+
          '<input type="text" class="form-control" id="instruccionAgregar" placeholder="Lavar en seco">'+
        '</div>'+
        '</div>',
        inputAttributes: {
          autocapitalize: 'off'
        },
        showCancelButton: true,
        cancelButtonColor: '#6C757D',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Agregar',
        confirmButtonColor:'#343A40',
        showLoaderOnConfirm: true,
        preConfirm: (login) => {
          return fetch(`//api.github.com/users/${login}`)
            .then(response => {
              if (!response.ok) {
                throw new Error(response.statusText)
              }
              return response.json()
            })
            .catch(error => {
              Swal.showValidationMessage(
                `Error: ${error}`
              )
            })
        },
        allowOutsideClick: () => !Swal.isLoading()
      }).then((result) => {
        if (result.value) {
          Swal.fire({
            title: `${result.value.login}'s avatar`,
            imageUrl: result.value.avatar_url
          })
        }
      })
  }
// Editar composicion
  function editarCuidado() {
      Swal.fire({
          title: 'Editar instrucci&oacute;n de cuidado',
          html:'<div class="row">'+
          '<div class="form-group col-sm-12">'+
            '<label>Nombre de la instrucci&oacute;n</label>'+
            '<input type="text" class="form-control" id="instruccionEditar" placeholder="Lavar en seco">'+
          '</div>'+
       '</div>',
          inputAttributes: {
            autocapitalize: 'off'
          },
          showCancelButton: true,
          cancelButtonColor: '#6C757D',
          cancelButtonText: 'Cancelar',
          confirmButtonText: 'Actualizar',
          confirmButtonColor:'#343A40',
          showLoaderOnConfirm: true,
          preConfirm: (login) => {
            return fetch(`//api.github.com/users/${login}`)
              .then(response => {
                if (!response.ok) {
                  throw new Error(response.statusText)
                }
                return response.json()
              })
              .catch(error => {
                Swal.showValidationMessage(
                  `Error: ${error}`
                )
              })
          },
          allowOutsideClick: () => !Swal.isLoading()
        }).then((result) => {
          if (result.value) {
            Swal.fire({
              title: `${result.value.login}'s avatar`,
              imageUrl: result.value.avatar_url
            })
          }
        })
    }
  // Dar de baja composicion
  function bajarCuidado(){
    Swal.fire({
      title: '¿Deseas dar de baja la instrucci&oacute;n de cuidado?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#343A40',
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
  // Reactivar composicion
  function reactivarCuidado(){
    Swal.fire({
      title: '¿Deseas reactivar la instrucci&oacute;n de cuidado?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#343A40',
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