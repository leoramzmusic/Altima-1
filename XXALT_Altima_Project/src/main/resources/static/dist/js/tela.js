var lookup;
$( document ).ready(function() {
    $.ajax({
        method: "GET",
           url: "/getTipo",
           
           data: {

               "_csrf": $('#token').val()
           },
           success: (data) => {
            lookup=data;
               for (i in data){
                   console.log("aqui"+data[i].idLookup);
+
                    $('#selecttipom').append("<option value='"+data[i].idLookup+"'>"+data[i].nombreLookup+"</option> ");

               }
               $('#selecttipom').selectpicker('refresh'); 
           },
          
           error: (e) => {
                location.reload();
           }
       });
});


$( "#selecttipom" ).change(function() {
    for(i in lookup){
        console.log("veri"+lookup[i].nombreLookup+" "+$("#selecttipom" ).children("option:selected").html());
        if($("#selecttipom" ).children("option:selected").html()==lookup[i].nombreLookup){
            console.log("aqui si entra"+lookup[i]);
            $.ajax({
                method: "GET",
                   url: "/getMaterial",
                   
                   data: {
                       "_csrf": $('#token').val(),
                       "tipo":lookup[i].nombreLookup
                   },
                   success: (data) => {
                       $("#selectmat").empty().append("<option selected disabled >Selecciona uno...</option>");
                       for (i in data){
                           console.log("aqui"+data[i].idMaterial);
        +
                            $('#selectmat').append("<option value='"+data[i].idMaterial+"'>"+data[i].nombreMaterial+"</option> ");
        
                       }
                       $('#selectmat').selectpicker('refresh'); 
                   },
                  
                   error: (e) => {
                        //location.reload();
                        console.log(error);
                   }
               });
        }
    }
  });

  $( "#addMat" ).click(function() {
    var _idmat = $("#selectmat" ).children("option:selected").val();
    var _textmat = $("#selectmat" ).children("option:selected").html();
    var _texttipo = $("#selecttipom" ).children("option:selected").html();
    var _idcol = $('#matcol').val();
    var _idcod = $('#matcod').val();
    var fila = "<tr><td style='display: none;'>" +_idmat + "</td>"+
        "<tr><td style='display: none;'>" +_texttipo + "</td>"+
		"<td>" + _textmat + "</td>"+
		"<td>" +_idcol+ "</td>"+
		"<td><input disabled type='color' id='color"+_idmat+"' value='"+_idcod+"'></td>"+
		"<td>" +'<button type="button" name="remove" id="' +_idmat + '"onclick="eliminarMaterial(this)" class="btn btn-danger btn_remove">Quitar</button></td>'+

		'</tr>';
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
		}
	});
	if(campo_id!=null){
		console.log("entra2 "+campo_id);
		for(var j=0;j<=campo_id.split(",").length;j++){

			if(_idmat==campo_id.split(",")[j]){
				console.log("entra3 "+_idmat);
				return false;
			}
		}
	}
	var btn = document.createElement("TR");
	btn.innerHTML = fila;
	document.getElementById("tablita").appendChild(btn);
  });

function eliminarMaterial(t) {
	var td = t.parentNode;
	var tr = td.parentNode;
	var table = tr.parentNode;
	table.removeChild(tr);
}