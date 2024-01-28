

'use strict';

$(function() {
	$("input[type='password'][data-eye]").each(function(i) {
		alert("heelo")
		var $this = $(this),
			id = 'eye-password-' + i,
			el = $('#' + id);

		$this.wrap($("<div/>", {
			style: 'position:relative',
			id: id
		}));

		$this.css({
			paddingRight: 60
		});
		$this.after($("<div/>", {
			html: 'Show',
			class: 'btn btn-primary btn-sm',
			id: 'passeye-toggle-' + i,
		}).css({
			position: 'absolute',
			right: 10,
			top: ($this.outerHeight() / 2) - 12,
			padding: '2px 7px',
			fontSize: 12,
			cursor: 'pointer',
		}));

		$this.after($("<input/>", {
			type: 'hidden',
			id: 'passeye-' + i
		}));

		var invalid_feedback = $this.parent().parent().find('.invalid-feedback');

		if (invalid_feedback.length) {
			$this.after(invalid_feedback.clone());
		}

		$this.on("keyup paste", function() {
			$("#passeye-" + i).val($(this).val());
		});
		$("#passeye-toggle-" + i).on("click", function() {
			if ($this.hasClass("show")) {
				$this.attr('type', 'password');
				$this.removeClass("show");
				$(this).removeClass("btn-outline-primary");
			} else {
				$this.attr('type', 'text');
				$this.val($("#passeye-" + i).val());
				$this.addClass("show");
				$(this).addClass("btn-outline-primary");
			}
		});
	});

	$(".my-login-validation").submit(function(event) { // Include the 'event' parameter
		var form = $(this);
		if (form[0].checkValidity() === false) {
			event.preventDefault();
			event.stopPropagation();
		}
		form.addClass('was-validated');
	});
});

/*save emial and pass word in local storage*/
const buttonlod= document.getElementById("submit");
const emials=document.getElementById("email");
const passwords=document.getElementById("password");
buttonlod.addEventListener("click",function (){
	const textsave=emials.value+passwords.value;
	if (typeof (Storage)!= "undefined"){
		localStorage.setItem("savedemail",textsave);
		alert("text aved in local");
	}else {
		alert("sorrry");
	}
})