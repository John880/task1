<html>
<body>

<h4>Currently available in our shop:</h4>
<div id="items">
	<ul></ul>
</div>

<br>
<h4>Your shopping:</h4>
<div id="item-choose">
	<ul></ul>
</div>
<span><button id="buy">Buy</button></span>
<span><button id="shopping">My shopping</button></span>

<script src="jquery.js"></script>
<script>
$(document).ready(function(){
	
	var shopping = {};
	
	var list = function(){
		$("#items ul").empty();
		$("#item-choose ul").empty();
		$.ajax({
			url: './items',
			success: function(ret){
				for(var i in ret) {
					var item = ret[i];
					$("#items ul").append('<li>Item '+item.name+': '+item.count+' left</li>');
					$("#item-choose ul").append('<li name="'+item.name+'">Item '+item.name+': <input type="text" id="item'+item.name+'" /></li>');
				}
			}
		})	
	};
	
	list();
	
	$('#buy').on('click', function(){
		$("#item-choose ul li").each(function(index){
			var name = $(this).attr('name');
			var count = $('#item' + name).val();
			if(count && count > 0) {
				$.ajax({
					url: './buy/' + name + '/' + count,
					success: function(){
						if(shopping[name] == undefined) {
							shopping[name] = count;
						}else{
							shopping[name] = shopping[name] + count;
						}
						console.log(shopping);
					}
				});
			}
		});
		
		list();
	});
	
	$('#shopping').on('click', function(){
		console.log(shopping);
		var msg = 'My shopping: \n';
		for(var i in shopping) {
			msg = msg + 'Item ' + i + ': ' + shopping[i] + ' \n';
		}
		alert(msg);
		
	});
});
</script>
</body>
</html>
