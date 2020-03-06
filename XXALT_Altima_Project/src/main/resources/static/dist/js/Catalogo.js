//Agregar Marca
function agregarMarca() {
    Swal.fire({
        title: 'Agregar marca',
        html:'<input class="swal2-input" placeholder="Nombre de la marca">',
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
  //Dar de baja marca
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
  //Reactivar marca
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
//Agregar Color
  function agregarColor() {
    Swal.fire({
        title: 'Agregar color',
        html:'<input class="swal2-input" placeholder="Nombre de la marca">',
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
  //Dar de baja color
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
  //Reactivar color
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
  //Agregar Material
  function agregarMaterial() {
    Swal.fire({
        title: 'Agregar material',
        html:'<input class="swal2-input" placeholder="Nombre de la marca">',
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

  //Dar de baja material
  function bajarMaterial(){
    Swal.fire({
      title: '¿Deseas dar de baja el material?',
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
          title: 'Dado de baja correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
  //Reactivar material
  function reactivarMaterial(){
    Swal.fire({
      title: '¿Deseas reactivar el material?',
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
          title: 'Reactivado correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
  //Agregar Pieza de Trazo
  function agregarTrazo() {
    Swal.fire({
        title: 'Agregar pieza de trazo',
        html:'<input class="swal2-input" placeholder="Nombre de la marca">',
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
  //Dar de baja pieza de trazo
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
  //Reactivar pieza de trazo
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
  //Agregar Forro
  function agregarForro() {
    Swal.fire({
        title: 'Agregar forro',
        html:'<input class="swal2-input" placeholder="Nombre de la marca">',
        inputAttributes: {
          autocapitalize: 'off'
        },
        showCancelButton: true,
        cancelButtonColor: '#6C757D',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Agregar',
        confirmButtonColor:'#1F2D3D',
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
  //Dar de baja forro
  function bajarForro(){
    Swal.fire({
      title: '¿Deseas dar de baja el forro',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#1F2D3D',
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
  //Reactivar forro
  function reactivarForro(){
    Swal.fire({
      title: '¿Deseas reactivar el forro?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#1F2D3D',
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
  //Agregar tela
  function agregarTela() {
    Swal.fire({
        title: 'Agregar tela',
        html:'<input class="swal2-input" placeholder="Nombre de la marca">',
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
  //Dar de baja tela
  function bajarTela(){
    Swal.fire({
      title: '¿Deseas dar de baja la tela',
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
  //Reactivar tela
  function reactivarTela(){
    Swal.fire({
      title: '¿Deseas reactivar la tela?',
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
  //Agregar Familia de prendas
  function agregarPrenda() {
    Swal.fire({
        title: 'Agregar familia de prenda',
        html:'<input class="swal2-input" placeholder="Nombre de la marca">',
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
  //Dar de baja prenda
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
  //Reactivar prenda
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
  //Agregar familia de genero
  function agregarGenero() {
    Swal.fire({
        title: 'Agregar familia de g&eacute;nero',
        html:'<input class="swal2-input" placeholder="Nombre de la marca">',
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
  //Dar de baja familia de genero
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
  //Reactivar familia de genero
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
  //Agregar Mantenimiento de prendas
  function agregarMantenimiento() {
    Swal.fire({
        title: 'Agregar mantenimiento de prendas',
        html:'<input class="swal2-input" placeholder="Nombre de la marca">',
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
  //Dar de baja mantenimiento de prendas
  function bajarMantenimiento(){
    Swal.fire({
      title: '¿Deseas dar de baja el mantenimiento de prendas?',
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
          title: 'Dado de baja correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
  //Reactivar mantenimiento de prendas
  function reactivarMantenimiento(){
    Swal.fire({
      title: '¿Deseas reactivar el mantenimiento de prendas?',
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
          title: 'Reactivado correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }