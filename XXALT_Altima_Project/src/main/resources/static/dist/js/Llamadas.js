  // ////////////////////////
// Habilitar form de SweetAlert2
$('#llamadasAgente').on('shown.bs.modal', function() {
     $(document).off('focusin.modal');
 });

function agendarLlamadaAgente(){
	Swal.fire({
		  title: 'Agendar llamada',
		  html:'<div class="row">'+
		  	'<div class="form-group col-sm-12">'+
	          '<label>Fecha de la llamada</label>'+
	          '<input type="date" class="form-control" id="fechaLlamada">'+
	        '</div>'+
	        '<input type="hidden" id="estatusLlamada" value="Pendiente">'+
	        '<div class="form-group col-sm-12">'+
	          '<label>Observaciones</label>'+
	          '<textarea class="form-control" id="observacionLlamada"></textarea>'+
	        '</div>'+
	        '</div>',
		  showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Agendar',
	      confirmButtonColor:'#343a40',
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
		          `Request failed: ${error}`
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

function editarLlamadaAgente(){
	Swal.fire({
		  title: 'Actualizar llamada',
		  html:'<div class="row">'+
	        '<div class="form-group col-sm-12">'+
	          '<label>Estatus</label>'+
	          '<select class="form-control" id="cambioestatusLlamada">'+
	            '<option>Pospuesta</option>'+
	            '<option>Realizada</option>'+
	            '<option>Cancelada</option>'+
	          '</select>'+
	        '</div>'+
	        '<div class="form-group col-sm-12">'+
	          '<label>Observaciones</label>'+
	          '<textarea class="form-control" id="cambioobservacionLlamada"></textarea>'+
	        '</div>'+
	        '</div>',
		  showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Actualizar',
	      confirmButtonColor:'#343a40',
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
		          `Request failed: ${error}`
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

// ////////////////////////
//Habilitar form de SweetAlert2
$('#accionesClienteAgente').on('shown.bs.modal', function() {
  $(document).off('focusin.modal');
});

function editarObservacionesClienteAgente(){
	Swal.fire({
		  title: 'Actualizar observaciones',
		  html:'<div class="row">'+
	        '<div class="form-group col-sm-12">'+
	          '<label>Observaciones</label>'+
	          '<textarea class="form-control" id="cambioobservacionCliente"></textarea>'+
	        '</div>'+
	        '</div>',
	  	  showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Actualizar',
	      confirmButtonColor:'#343a40',
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
		          `Request failed: ${error}`
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

		
