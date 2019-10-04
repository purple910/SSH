$(function () {
	var $name = $('#name')
	var $pwd = $('#password')
	var name = $name.text()
	var pwd = $pwd.text()
	var is = true

	$name.blur(function () {
		if(name.length<=0||name.length>=10){
			$('.name').show()
			$name.focus()
		}
	});
	$name.on('input',function () {
		console.log(this)
		$('.name').hide()
	})

	$pwd.blur(function () {
		if(pwd.length<=0||pwd.length>=10){
			$('.pwd').show()
			$pwd.focus()
		}
	});
	$pwd.on('input',function () {
		$('.pwd').hide()
	})

	$('button:first').click(function () {
		if(pwd.length<=0||pwd.length>=10){
			$('.pwd').show()
			$pwd.focus()
			is = false
		}
		if(name.length<=0||name.length>=10){
			$('.name').show()
			$name.focus()
			is = false
		}
	});
	if(is){
		$.post('',{name:name,password:pwd},function (status,response) {
			if(status=='success'){
				if($(response).state=='error'){
					$('.error').show()
				}
			}
		})
	}
});