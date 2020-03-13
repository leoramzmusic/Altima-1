//PRIMERA IMAGEN
function uploadPreview1(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function(e) {
      if (e.target.result.trim().length == 0) {
        $('#serviceImage1').attr('src', 'http://catawbabrewing.com/wp-content/themes/catawba/images/placeholder.png');
      } else {
        $('#serviceImage1').attr('src', e.target.result);
      }
    }

    reader.readAsDataURL(input.files[0]);
  }
}

function uploadPreviewExt1(input) {
  if (input.trim().length == 0) {
    var previewSrc = '{{CSS_URL}}/images/placeholder.jpg';
  } else {
    var previewSrc = input;
  }

  $('#serviceImage1').attr('src', previewSrc);
}

function resetUploadPreview1() {
  if (!$('#previousImage1').val()) {
    $('#serviceImage1').attr('src', 'http://catawbabrewing.com/wp-content/themes/catawba/images/placeholder.png');
  } else {
    $('#serviceImage1').attr('src', '{{PROD_IMG}}/'.$('#previousImage1').val());
  }
}

$("#mainImage1").change(function() {
  uploadPreview1(this);
});

$('[name="mainImgExt1"]').on('change', function() {
  uploadPreviewExt1(this.value);
});

$('#clearUpload1').on('click', function() {
  $('#mainImage1').val('');

  if ($('#imgExt1').val().trim().length == 0) {
    resetUploadPreview1();
  } else {
    uploadPreviewExt1($('#imgExt1').val());
  }
});

$('#clearUploadExt1').on('click', function() {
  $('#imgExt1').val('');

  if (!$('#mainImage1').val()) {
    resetUploadPreview1();
  } else {
    uploadPreview1($('#mainImage1'));
  }
});

//SEGUNDA IMAGEN
function uploadPreview(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();

	    reader.onload = function(e) {
	      if (e.target.result.trim().length == 0) {
	        $('#serviceImage').attr('src', 'http://catawbabrewing.com/wp-content/themes/catawba/images/placeholder.png');
	      } else {
	        $('#serviceImage').attr('src', e.target.result);
	      }
	    }

	    reader.readAsDataURL(input.files[0]);
	  }
	}

	function uploadPreviewExt(input) {
	  if (input.trim().length == 0) {
	    var previewSrc = '{{CSS_URL}}/images/placeholder.jpg';
	  } else {
	    var previewSrc = input;
	  }

	  $('#serviceImage').attr('src', previewSrc);
	}

	function resetUploadPreview() {
	  if (!$('#previousImage').val()) {
	    $('#serviceImage').attr('src', 'http://catawbabrewing.com/wp-content/themes/catawba/images/placeholder.png');
	  } else {
	    $('#serviceImage').attr('src', '{{PROD_IMG}}/'.$('#previousImage').val());
	  }
	}

	$("#mainImage").change(function() {
	  uploadPreview(this);
	});

	$('[name="mainImgExt"]').on('change', function() {
	  uploadPreviewExt(this.value);
	});

	$('#clearUpload').on('click', function() {
	  $('#mainImage').val('');

	  if ($('#imgExt').val().trim().length == 0) {
	    resetUploadPreview();
	  } else {
	    uploadPreviewExt($('#imgExt').val());
	  }
	});

	$('#clearUploadExt').on('click', function() {
	  $('#imgExt').val('');

	  if (!$('#mainImage').val()) {
	    resetUploadPreview();
	  } else {
	    uploadPreview($('#mainImage'));
	  }
	});